package likeinhaskell;

/**
 * Created by Niklas on 2016-02-07.
 */
public interface Function<T,R> {
    R apply(T t);

    // TODO: Step 6: Can you broaden the parameter type for
    //   the parameter 'other', to make 'compose' work for
    //   a wider range of functions?
    default <A> Function<A, R> compose(Function<A, ? extends T> other) {
        return x -> apply(other.apply(x));
    }

}
