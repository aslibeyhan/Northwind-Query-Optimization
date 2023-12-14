package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.business.dtos.ProductWithCategoryDto;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {

    private ProductService productService;
    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
         return this.productService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId( @RequestParam int categoryId,@RequestParam String productName){
       return this.productService.getByProductNameAndCategoryId(productName,categoryId);

    }
    @GetMapping("/getByProductNameContains")
   public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted(){
        return  this.productService.getAllSorted();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return  this.productService.getProductWithCategoryDetails();
    }
}
