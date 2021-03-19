package pad.InstagramClone.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pad.InstagramClone.Service.UserService;
import pad.InstagramClone.Users.User;
import java.util.List;
@RestController
public class Usercontroller {
@Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User usr)
    {
        return service.saveProduct(usr);
    }

    @PostMapping("/addUsers")
    public List<User> addProducts(@RequestBody List<User> usr) {
        return service.saveProducts(usr);
    }

    @GetMapping
    public List<User> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public User findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public User findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }


    @PutMapping("/update")
    public User updateProduct(@RequestBody User usr) {
        return service.updateProduct(usr);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

}
