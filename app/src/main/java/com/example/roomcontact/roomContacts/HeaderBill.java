package com.example.roomcontact.roomContacts;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "HeaderBill",indices = @Index(value = {"LastUUID"},unique = true))

public class HeaderBill {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "LastUUID")
    String LastUUID;

    @ColumnInfo(name = "BillNumber")
    String BillNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastUUID() {
        return LastUUID;
    }

    public void setLastUUID(String lastUUID) {
        LastUUID = lastUUID;
    }

    public String getBillNumber() {
        return BillNumber;
    }

    public void setBillNumber(String billNumber) {
        BillNumber = billNumber;
    }
}
