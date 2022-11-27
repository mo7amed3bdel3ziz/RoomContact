package com.example.roomcontact.roomContacts;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "ContactsTable",indices = @Index(value = {"INTERNALCODE"},unique = true))

public class ContactsRoom {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "INTERNALCODE")
    String INTERNALCODE;

    @ColumnInfo(name = "DESCRIPTION")
    String DESCRIPTION;

    @ColumnInfo(name = "ITEMCODE")
    String ITEMCODE;

    @ColumnInfo(name = "QUANTITY")
    String QUANTITY;

    @ColumnInfo(name = "UNITPRICE")
    String UNITPRICE;

    @ColumnInfo(name = "NETSALE")
    String NETSALE;

    @ColumnInfo(name = "TOTALSALE")
    String TOTALSALE;

    @ColumnInfo(name = "TOTAL")
    String TOTAL;

    @ColumnInfo(name = "T1AMOUNT")
    String T1AMOUNT;
    @ColumnInfo(name = "RATE")
    String RATE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getINTERNALCODE() {
        return INTERNALCODE;
    }

    public void setINTERNALCODE(String INTERNALCODE) {
        this.INTERNALCODE = INTERNALCODE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getITEMCODE() {
        return ITEMCODE;
    }

    public void setITEMCODE(String ITEMCODE) {
        this.ITEMCODE = ITEMCODE;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getUNITPRICE() {
        return UNITPRICE;
    }

    public void setUNITPRICE(String UNITPRICE) {
        this.UNITPRICE = UNITPRICE;
    }


    //   public ContactsRoom(String name, String number, String email) {
//       this.name = name;
//       this.number = number;
//       this.email = email;
//     //  Log.i("InitContact",""+name+number+email);
//   }

//   public int getId() {
//       return id;
//   }

//   public void setId(int id) {
//       this.id = id;
//   }

//   public String getName() {
//       return name;
//   }

//   public void setName(String name) {
//       this.name = name;
//   }

//   public String getNumber() {
//       return number;
//   }

//   public void setNumber(String number) {
//       this.number = number;
//   }

//   public String getEmail() {
//       return email;
//   }

//   public void setEmail(String email) {
//       this.email = email;
//   }
}


