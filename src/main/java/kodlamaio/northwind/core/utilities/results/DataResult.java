package kodlamaio.northwind.core.utilities.results;

public class DataResult<T> extends  Result{
    private T data;
    public DataResult(T data, boolean success, String message) {
        super(success, message);  //base sınıfın ctor çalıştırır.
        this.data=data;
    }

    public DataResult(T data, boolean success) {
        super(success);  //base sınıfın ctor çalıştırır.
        this.data=data;
    }

    //base sınıfta message ve success alanının getter var so okunur
    //T data yı okumak için gettter yazalım
     public T getData(){
        return this.data;
     }
}
