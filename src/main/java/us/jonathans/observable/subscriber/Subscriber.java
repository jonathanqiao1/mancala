package us.jonathans.observable.subscriber;

public interface Subscriber<T> {
    void onNext(T t);
}
