package com.example.exam.Service;

import com.example.exam.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    ArrayList<UserModel>list=new ArrayList<>();

    //get all
     public  ArrayList<UserModel>getAll(){
        return list;
    }

    //add new
    public void  addNew(UserModel userModel){
        list.add(userModel);

    }

    //update
    public boolean updateUseers(String id,UserModel userModel){
         for(UserModel userId: list){
             if (userId.getId().equals(id)){
                 int i= list.indexOf(userId);
                 list.set(i,userModel);
                 return  true;
             }
         }
         return false;
    }

    public boolean delete(String id){
         for (UserModel checkid: list){
             if (checkid.getId().equals(id)){
                 int i=list.indexOf(checkid);
                 list.remove(i);
                 return true;
             }
         }
         return false;

    }

    //return dependence on balence

public ArrayList<UserModel>getByBalence(int balance){
         ArrayList<UserModel>bal=new ArrayList<>();
         for (UserModel model:list){
             if (model.getBalance()>=balance){
                 bal.add(model);

             }
         }
         if (bal.isEmpty()){
             return null ;
         }
         else {
             return bal;
         }


}

//get by age
public ArrayList<UserModel>getByAge(int age){
         ArrayList<UserModel>agerange=new ArrayList<>();
         for (UserModel model:list){
             if (model.getAge()>=age){
                 agerange.add(model);
             }
         }
         if (agerange.isEmpty()){
             return null;
         }
         else {
             return agerange;
         }

}





}


