package com.example.AgricultureMarketSystem.controller;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.AgricultureMarketSystem.domain.AdminLogin;
import com.example.AgricultureMarketSystem.domain.Crop;
import com.example.AgricultureMarketSystem.domain.Login;
import com.example.AgricultureMarketSystem.domain.Merchant;
import com.example.AgricultureMarketSystem.domain.User;
import com.example.AgricultureMarketSystem.repository.CropRepository;
import com.example.AgricultureMarketSystem.repository.UserRepository;
import com.example.AgricultureMarketSystem.service.AdminLoginService;
import com.example.AgricultureMarketSystem.service.CropService;
import com.example.AgricultureMarketSystem.service.LoginService;
import com.example.AgricultureMarketSystem.service.RegisterService;
import com.example.AgricultureMarketSystem.service.UserService;


@Controller
public class ProductController {
	
	private  String username ="";
	private int id=0;
	private String crop_name=""; 
	
	 @Autowired
	    private CropService service;
	 
	 @Autowired
	    private UserService userService;
	 

	 @Autowired
	 	private RegisterService register;
	 
	 @Autowired
	 	private LoginService loginService;
	 
	 @Autowired
	 	private AdminLoginService adminloginService;
	 

	 @Autowired
		private CropRepository cropRepo;

	 @Autowired
	 	private UserRepository userRepo;
	 
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        List<Crop> listproduct = service.listAll();
	        model.addAttribute("listproduct", listproduct);
	        System.out.print("Get / ");	
	        return "index";
	    }
	    
        
@GetMapping("/Flogin")
public ModelAndView Flogin() {
ModelAndView mav = new ModelAndView("login");
mav.addObject("user", new Login());
return mav;
}

@PostMapping("/Flogin")
public String Flogin(Model model,@ModelAttribute("user") Login user ) {

	Login oauthUser = loginService.login(user.getUsername(), user.getPassword());
	username = user.getUsername();
	model.addAttribute("username", user.getUsername());
	System.out.print("Username ID :"+oauthUser.getId());
	id = oauthUser.getId();
if(Objects.nonNull(oauthUser)) 
{	

return "redirect:/Farmer_Home";


} else {
return "redirect:/";


}    
}   



@GetMapping("/Mlogin")
public ModelAndView Mlogin() {
ModelAndView mav = new ModelAndView("login");
mav.addObject("user", new Login());
return mav;
}

@PostMapping("/Mlogin")
public String Mlogin(Model model,@ModelAttribute("user") Login user ) {

Login oauthUser = loginService.login(user.getUsername(), user.getPassword());
username = user.getUsername();
model.addAttribute("username", user.getUsername());
model.addAttribute("merchant_id", user.getId());
id = oauthUser.getId();
System.out.println("Merchant ID : "+ id);
if(Objects.nonNull(oauthUser)) 
{	

return "redirect:/Merchant_Home";


} else {
return "redirect:/";


}    
} 


@GetMapping("/adminlogin")
public ModelAndView adminlogin() {
ModelAndView mav = new ModelAndView("adminlogin");
mav.addObject("adminlogin", new AdminLogin());
return mav;
}

@PostMapping("/adminlogin")
public String adminlogin(Model model,@ModelAttribute("adminlogin") AdminLogin user ) {

	AdminLogin oauthUser = adminloginService.login(user.getUsername(), user.getPassword());
	username = user.getUsername();
	model.addAttribute("username", user.getUsername());
	System.out.print("Username ID :"+oauthUser.getId());
	//id = oauthUser.getId();
if(Objects.nonNull(oauthUser)) 
{	

return "redirect:/Home";


} else {
return "redirect:/AdminLogin";


}    
} 

	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("crop", new Crop());
	        return "new";
	    }
	    
	    @GetMapping("/AdminLogin")
	    public String admin(Model model) {
	        model.addAttribute("crop", new Crop());
	        return "AdminLogin";
	    }
	    
	    @GetMapping("/listProducts")
	    public String list(Model model) {
	    	List<Crop> crops=cropRepo.findAll();
	        model.addAttribute("crops", crops); 
	        return "listProducts";
	    } 
	    
	    
	    @GetMapping("/listFarmers")
	    public String farmers(Model model) {
	    	List<User> farmers=userRepo.findFarmers();
	        model.addAttribute("farmers", farmers); 
	        return "listFarmers";
	    } 
	    
	    
	    @GetMapping("/listMerchants")
	    public String merchants(Model model) {
	    	List<User> merchants=userRepo.findMerchant();
	        model.addAttribute("merchants", merchants); 
	        return "listMerchants";
	    } 
	    
	    @GetMapping("/MerchantCrops")
	    public String merchantcrops(Model model) {
	    	List<Crop> crops=cropRepo.getByUser(id);
	        model.addAttribute("crops", crops); 
	        return "MerchantCrops";
	    } 
	    
	    @GetMapping("/MerchantList")
	    public String merchantList(Model model,@ModelAttribute("crop") String crop ) {
	    	
	    	//System.out.println("Data "+ cropRepo.getByCrop(crop));
	    	List<Crop> merchant=cropRepo.getByCrop(crop);
	    	
	      //  model.addAttribute("merchant", merchant); 
	        return "Farmer_Home";
	    } 
	    
	    @GetMapping("/register")
	    public String send(Model model) {
	        model.addAttribute("crop", new Crop());
	        return "UserRegistration";
	    }
	    
	    @GetMapping("/Home")
	    public String home(Model model) {
	        System.out.println("Username : "+username);
	        return "Home";
	    }
	    
	    @GetMapping("/ViewProduct")
	    public String viewProduct(Model model) {
	        model.addAttribute("crop", new Crop());
	        return "ViewProduct";
	    }

	    
	    @GetMapping("/ReceiveProducts")
	    public String receiveProduct(Model model) {
	    	List<Crop> products=cropRepo.findAll();
	        model.addAttribute("products", products);
	        return "ReceiveProducts";
	    }
	    
	    @GetMapping("/ViewProfile")
	    public String viewProfile(Model model) {
	    	System.out.println("Username :" + username+" and ID :" +id);
	    	User user=register.get(id);
	    	System.out.println("First_Name : ");
	        model.addAttribute("user", user);
	        return "ViewProfile";
	    }
	    
	    @GetMapping("/Farmer_Profile")
	    public String Farmer_Profile(Model model) {
	    	System.out.println("Username :" + username+" and ID :" +id);
	    	User user=register.get(id);
	    	System.out.println("First_Name : ");
	        model.addAttribute("user", user);
	        return "Farmer_Profile";
	    }
	    
	    @GetMapping("/Merchant_Profile")
	    public String Merchant_Profile(Model model) {
	    	System.out.println("Username :" + username+" and ID :" +id);
	    	User user=register.get(id);
	    	System.out.println("First_Name : ");
	        model.addAttribute("user", user);
	        return "Merchant_Profile";
	    }
	    
	    @RequestMapping("/Show_Merchant_Profile/{id}")
	    public String show_Merchant_Profile(@PathVariable(name = "id") int merchant_id,Model model) {
	    	User user=register.get(merchant_id);
	        model.addAttribute("user", user);
	        return "Merchant_List";
	    }
	    
	    @GetMapping("/OwnerDetails")
	    public String viewOwner(Model model) {
	    	System.out.println("Username :" + username+" and ID :" +id);
	    	User user=register.get(id);
	    	System.out.println("First_Name : ");
	        model.addAttribute("user", user);
	        return "OwnerDetails";
	    }
	    
	    @RequestMapping("/ViewProduct/{id}")
	    public String viewmyproduct(@PathVariable(name = "id") String value, Model model) {
	    	System.out.println("Username :" + username+" and ID :" +value);
	    	int id1 = Integer.parseInt(value);
	    	System.out.println("Username :" + username+" and ID :" +id1);
	    	Crop product=service.get(id1);
	        model.addAttribute("product", product);
	        return "ViewProduct";
	    }
	    
	    @GetMapping("/AddCrop")
	    public String AddCrop(Model model) {
	        model.addAttribute("product", new Crop());
	        return "AddCrop";
	    }
	    
	    @GetMapping("/Farmer_Login")
	    public String Farmer_Login(Model model) {
	        model.addAttribute("product", new Crop());
	        return "Farmer_Login";
	    }
	    
	    @GetMapping("/Merchant_Login")
	    public String Merchant_Login(Model model) {
	        model.addAttribute("product", new Crop());
	        return "Merchant_Login";
	    }
	    
	    @GetMapping("/Farmer_Home")
	    public String Farmer_Home(Model model) {
	        model.addAttribute("product", new Crop());
	        return "Farmer_Home";
	    }
	    @GetMapping("/Merchant_Home")
	    public String Merchant_Home(Model model) {
	        model.addAttribute("product", new Crop());
	        return "Merchant_Home";
	    }
	    
	
	    @RequestMapping(value = "/saveCrop", method = RequestMethod.POST)
	    public String saveProduct(
	    		@RequestParam("crop_name")String crop_name,
	    		@RequestParam("price")int price,
	    		@RequestParam("quantity")int quantity
	    		
	    		) throws IllegalStateException, IOException {
	    	
	    	Crop crop= new Crop();
	    	
	    	crop.setCrop_name(crop_name);
	    	crop.setPrice(price);
	    	crop.setQuantity(quantity);
	    	crop.setMerchant_id(id);
	   
	        service.save(crop);
	        
	     //   fileUploadService.uploadFile(file);
	        
	        return "redirect:/Merchant_Home";
	    }
	    
	    
	    @RequestMapping(value = "/showMerchant", method = RequestMethod.POST)
	    public String showMerchant(Model model,
	    		@RequestParam("crop")String crop
	    		) throws IllegalStateException, IOException {
	    	
	        
	    	model.addAttribute("crop",crop );
	    	crop_name=crop;
	    	System.out.println("Crop Value : " + crop);
	    	
	        return "/Farmer_Home";
	    }
	    
	    @GetMapping("/Back_To_Farmer_Home")
	    public String Back_Farmer_Home(Model model) {
	        model.addAttribute("crop",crop_name);
	        return "/Farmer_Home";
	    }
	    
	    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	    public String saveUser(@ModelAttribute("user") User std) {
	        register.save(std);
	        return "redirect:/";
	    }

	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        Crop std = service.get(id);
	        mav.addObject("product", std);
	        return mav;
	        
	    }
	    @RequestMapping("/RemoveProduct/{id}")
	    public String deleteproduct(@PathVariable(name = "id") String value) {
	    
	    	System.out.println("String :"+value);
	    	int id = Integer.parseInt(value);
	    	System.out.println("Int :"+id);
	       service.delete(id);
	        return "redirect:/MerchantCrops";
	    }
	    @RequestMapping("/RemoveFarmer/{id}")
	    public String deletefarmer(@PathVariable(name = "id") String value) {
	    
	    	System.out.println("String :"+value);
	    	int id = Integer.parseInt(value);
	    	System.out.println("Int :"+id);
	       userService.delete(id);
	        return "redirect:/listFarmers";
	    }
	    @RequestMapping("/RemoveMerchants/{id}")
	    public String deletemerchant(@PathVariable(name = "id") String value) {
	    
	    	System.out.println("String :"+value);
	    	int id = Integer.parseInt(value);
	    	System.out.println("Int :"+id);
	       userService.delete(id);
	        return "redirect:/listMerchants";
	    }
	    
}