/**
 * Interface for objects that can transport other objects. Has a load and unload method.
 * @author Julia Molin, Jacob Allestam
 *
 * @param <T> Any object. 
 */
public interface Transporter<T>{
    public void load(T object);
    public T unload();
}
