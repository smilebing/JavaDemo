package EnumSave;

/**
 * Created by zhuhe on 2018/4/26.
 */
public interface HasDefaultInterface<T> extends HasValueInterface {
    T getDefault();
}
