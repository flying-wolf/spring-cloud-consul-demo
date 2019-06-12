package org.springframework.cloud.netflix.turbine.stream;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;

import com.netflix.turbine.aggregator.InstanceKey;
import com.netflix.turbine.aggregator.StreamAggregator;
import com.netflix.turbine.internal.JsonUtility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import reactor.core.publisher.Flux;
import rx.Observable;
import rx.RxReactiveStreams;
import rx.subjects.PublishSubject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Turbine stream controller.
 *
 * @author Spencer Gibb
 * @author Ryan Baxter
 */
@RestController
public class TurbineController {

    private static final Log log = LogFactory.getLog(TurbineController.class);

    private final Flux<String> flux;

    public TurbineController(PublishSubject<Map<String, Object>> hystrixSubject) {
        Observable<Map<String, Object>> stream = StreamAggregator
                .aggregateGroupedStreams(hystrixSubject.groupBy(
                        data -> InstanceKey.create((String) data.get("instanceId"))))
                .doOnUnsubscribe(() -> log.info("Unsubscribing aggregation."))
                .doOnSubscribe(() -> log.info("Starting aggregation sdfsdfs")).flatMap(o -> o);
        Flux<Map<String, Object>> ping = Flux
                .interval(Duration.ofSeconds(5), Duration.ofSeconds(10))
                .map(l -> Collections.singletonMap("type", (Object) "ping")).share();
        flux = Flux.merge(RxReactiveStreams.toPublisher(stream), ping).share()
                .map(map -> JsonUtility.mapToJson(map));
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> stream() {

        System.out.println("sdfsdfs-----------------");


        this.flux.subscribe(System.out::println);

        return this.flux;
    }

}
