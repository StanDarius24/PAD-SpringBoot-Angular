package pad.InstagramClone.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pad.InstagramClone.Repository.UserRep;
import pad.InstagramClone.Users.User;

import java.util.List;
@Service
public class UserService{
    @Autowired
    private UserRep userRep;
    public User saveProduct(User usr) {
        return userRep.save(usr);
    }

    public List<User> saveProducts(List<User> usr) {
        return userRep.saveAll(usr);
    }

    public List<User> getProducts() {
        return userRep.findAll();
    }

    public User getProductById(int id) {
        return userRep.findById(id).orElse(null);
    }

    public User getProductByName(String name) {
        return userRep.findByName(name);
    }

    public String deleteProduct(int id) {
        userRep.deleteById(id);
        return "product removed !! " + id;
    }

    public User updateProduct(User usr) {
        User existingProduct = userRep.findById(usr.getId()).orElse(null);
        existingProduct.setName(usr.getName());
        existingProduct.setPass(usr.getPass());
        return userRep.save(existingProduct);
    }
}
