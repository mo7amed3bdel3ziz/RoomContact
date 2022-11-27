package com.example.roomcontact;

import static io.reactivex.rxjava3.schedulers.Schedulers.computation;
import static io.reactivex.rxjava3.schedulers.Schedulers.io;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.roomcontact.roomContacts.ContactsDatabase;
import com.example.roomcontact.roomContacts.ContactsRoom;
import com.example.roomcontact.roomContacts.HeaderBill;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    Button button,button2,button3;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        textView2=findViewById(R.id.textView2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRoom();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactsRoom post=new ContactsRoom (
                        // "111",
                        // "جولد ستاندر زيت زيتون 1 لتر",
                        // "99999999",
                        // "2.0",
                        // "50.0",
                        // "100.0000",
                        // "100.0000",
                        // "114.0000",
                        // "14.0000",
                        // "14.0"
                );
                post.setINTERNALCODE("12");
                post.setDESCRIPTION("laasfhsp");
                setBill( post);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  ContactsRoom post=new ContactsRoom (
              //          "196",
              //          "جولد ستاندر زيت زيتون 1 لتر",
              //          "99999999",
              //          "2.0",
              //          "50.0",
              //          "100.0000",
              //          "100.0000",
              //          "114.0000",
              //          "14.0000",
              //          "14.0"
              //  );
              //  post.setINTERNALCODE("654");
              //  post.setDESCRIPTION("laasp");
              //  setBill( post);

                HeaderBill post=new HeaderBill();
                post.setBillNumber("123");
                post.setLastUUID("فوزى");

                ArrayList<ContactsRoom> postitem =new ArrayList<>();
                ContactsRoom room=new ContactsRoom();
                room.setITEMCODE("123");
                room.setDESCRIPTION("فوزى");
                ContactsRoom room1=new ContactsRoom();
                room1.setITEMCODE("123");
                room1.setDESCRIPTION("فوزى");

                postitem.add(room);
                postitem.add(room1);

                headBill( post,postitem );
            }
        });



    }
    public void headBill(HeaderBill post, ArrayList<ContactsRoom> postitem){


        ContactsDatabase postsDataBass =  ContactsDatabase.getGetInstance(getApplicationContext());
        //  postsDataBass.contactsDao().insertContacts()
        postsDataBass.headerBillDao().insertHeaderBill(post)
     //   postsDataBass.contactsDao().insertContacts(post)


                .subscribeOn(computation())

                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("yousiiiif","complete1");

                        Observable ob = Observable.create(new ObservableOnSubscribe<ContactsRoom>() {
                                    @Override
                                    public void subscribe(@NonNull ObservableEmitter<ContactsRoom> emitter) throws Exception {

                                        ArrayList<ContactsRoom> postArrayList = postitem;
                                        for (ContactsRoom x : postArrayList) {
                                            emitter.onNext(x);

                                        }
                                    }
                                }).subscribeOn(io())
                                .observeOn(computation());
                        Observer obs = new Observer<ContactsRoom>() {


                            @Override
                            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@io.reactivex.rxjava3.annotations.NonNull ContactsRoom contactsRoom) {
                                setBill(contactsRoom);
                            }

                            @Override
                            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                Log.d("yousiiiif",e.getMessage().toString());
                            }

                            @Override
                            public void onComplete() {
                                Log.d("yousiiiif","complete2");
                            }
                        };
                        ob.subscribe(obs);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("yousiiiif",e.getMessage().toString());
                    }
                });

    }


    public void setBill(ContactsRoom post){


        ContactsDatabase postsDataBass =  ContactsDatabase.getGetInstance(getApplicationContext());
        //  postsDataBass.contactsDao().insertContacts()
        postsDataBass.contactsDao().insertContacts(post)

                .subscribeOn(computation())

                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("yousiiiif","complete3");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });

    }
    public void getRoom(){
        ContactsDatabase contactsDatabase=ContactsDatabase.getGetInstance(this);
        contactsDatabase.contactsDao().getContacts()
                //getlistItems("123")
                .subscribeOn(computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ContactsRoom>>() {
                    @Override
                    public void onSubscribe(@androidx.annotation.NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@androidx.annotation.NonNull List<ContactsRoom> contactsRooms) {
                      // Log.d("yousiiiif",contactsRooms.get(1).getNumber().toString());

                        StringBuilder s=new StringBuilder();

                         for (int i=0;i==contactsRooms.size();i++){

                         contactsRooms.get(i).getINTERNALCODE();
                         contactsRooms.get(i).getDESCRIPTION()  ;
                         s.append(contactsRooms.get(i).getINTERNALCODE()+""+
                                 contactsRooms.get(i).getDESCRIPTION() ) ;
                       // textView2.append( contactsRooms.get(0).getINTERNALCODE()+"__" +contactsRooms.get(0).getDESCRIPTION());
                         }
                        Log.d("yousiiiif" ,contactsRooms.get(1).getINTERNALCODE()
                        +""+ contactsRooms.get(1).getDESCRIPTION());

                        textView2.setText(s.toString());
                        //   contactUsers=contactsRooms;

                        //   adapter.setContactUserslist(contactsRooms);
                        //   //  for (ContactsRoom r:contactsRooms){
                        //   //      Log.i("Contact","name:"+r.getName()+"number"+r.getNumber()+"email"+r.getEmail());
                        //   //  }
                        //   // adapter.notifyDataSetChanged();
//
                        //   binding.contactsrecy.setAdapter(adapter);
                    }

                    @Override
                    public void onError(@androidx.annotation.NonNull Throwable e) {
                        Log.d("yousiiiif",e.getMessage().toString());

                    }
                });

    }
}