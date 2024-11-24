package com.example.exam.Service;

import com.example.exam.Model.BookModel;
import com.example.exam.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

ArrayList<BookModel>list=new ArrayList<>();

    public ArrayList<BookModel> getAll(){
        return list;
    }

    //add new
    public void  addNew(BookModel bookModel){
        list.add(bookModel);

    }

    //update
    public boolean updatebook(String id,BookModel bookModel){
        for(BookModel bookId: list){
            if (bookId.getId().equals(id)){
                int i= list.indexOf(bookId);
                list.set(i,bookModel);
                return  true;
            }
        }
        return false;
    }

    public boolean delete(String id){
        for (BookModel checkid: list){
            if (checkid.getId().equals(id)){
                int i=list.indexOf(checkid);
                list.remove(i);
                return true;
            }
        }
        return false;

    }

    //get book by name
    public BookModel getByName(String name){
        for (BookModel model:list){
            if (model.getName().equals(name)){
                int i=list.indexOf(model);
               BookModel name1= list.get(i);
               return name1;
            }
        }
     return null;
    }


    //get by category
    public ArrayList<BookModel>getCategory(String catgory){
        ArrayList<BookModel>getCatgory=new ArrayList<>();
        for (BookModel model:list){
            if (model.getCategory().equals(catgory)){
                getCatgory.add(model);
            }
        }
        if (getCatgory.isEmpty()){
            return null;
        }
        else {
            return getCatgory;
        }
    }

    //number of pages
    public ArrayList<BookModel>getNumber(int numberOfpages){
        ArrayList<BookModel>number=new ArrayList<>();
        for (BookModel model:list){
            if (model.getNumberOfpages()>=numberOfpages){
                number.add(model);
            }
        }
        if (number.isEmpty()){
            return null;
        }
        else {
            return number;
        }
    }



    public boolean changeAvailable(String id){
        for (BookModel model:list){
            if (model.getId().equals(id)){
                int bookId=list.indexOf(model);
                return true;
            }

            if (model.isAvailable()==false){
                return false;
            }

            model.setAvailable(false);
        }


    }




}
