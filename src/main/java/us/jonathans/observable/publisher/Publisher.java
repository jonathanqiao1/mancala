package us.jonathans.observable.publisher;

import us.jonathans.observable.subscriber.Subscriber;

public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);

    void publish(T t);
}
