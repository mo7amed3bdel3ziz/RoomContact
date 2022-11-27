package com.example.roomcontact.roomContacts;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface ContactsDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertContacts(ContactsRoom user);

    @Query("select*from ContactsTable")
    Single<List<ContactsRoom>> getContacts();

    @Query("Select * from ContactsTable  WHERE ITEMCODE= :ITEMCODE")
    Single<List<ContactsRoom>> getlistItems(String ITEMCODE);

   // @Query("select*from aeaderBill")
   // Single<List<ContactsRoom>> getHeaderBill();


    //string query = "Select * From table Where number"
   // @Query("select UUID from ContactsTable where UUID = :num")
   // Single<String> getNumContacsts(String num);

//
  //  @Query("select * from ContactsTable where number = :num")
  //  Single<ContactsRoom> getNumContacts(String num);
  // // = null;
}
