package kodlamaio.northwind.core.utilities.results;

public class ErrorResult extends Result{

    //LOMBOK entitylerde kullanılır.burada işimizi görmez.Çünkü logic de kullanıyoruz.


    public ErrorResult(){
        super(false);
    }

    public  ErrorResult(String message){
        super(false, message);
    }
}
