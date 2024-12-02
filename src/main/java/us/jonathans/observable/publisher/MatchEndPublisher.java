package us.jonathans.observable.publisher;

import us.jonathans.data_access.match.InMemoryMatchDataAccess;
import us.jonathans.entity.match.EngineMatch;
import us.jonathans.observable.subscriber.Subscriber;

import java.util.ArrayList;

public class MatchEndPublisher implements Publisher<EngineMatch> {
    private static MatchEndPublisher singletonInstance = null;
    private final ArrayList<Subscriber<? super EngineMatch>> matches = new ArrayList<>();

    public static MatchEndPublisher getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MatchEndPublisher();
        }
        return singletonInstance;
    }


    @Override
    public void subscribe(Subscriber<? super EngineMatch> subscriber) {
        this.matches.add(subscriber);
    }

    @Override
    public void publish(EngineMatch engineMatch) {
        this.matches.forEach(subscriber -> subscriber.onNext(engineMatch));
    }
}
