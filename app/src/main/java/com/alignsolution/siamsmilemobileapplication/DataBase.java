package com.alignsolution.siamsmilemobileapplication;

/**
 * Created by aligndev on 05-May-17.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBase extends SQLiteOpenHelper  {
    private static final String DB_NAME = "SiamSmile";
    private static final int DB_VERSION = 1;
    public static final String TABLE_USER = "CREATE TABLE IF NOT EXISTS Users " +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " UserId TEXT," +
            " UserLogin  TEXT," +
            " Password   TEXT, " +
            " FirstName  TEXT," +
            " LastName   TEXT," +
            " CardNo     TEXT," +
            " BirthDate  TEXT," +
            " Email      TEXT," +
            " PhoneNumber1  TEXT," +
            " PhoneNumber2  TEXT," +
            " HomeAddress   TEXT," +
            " WorkAddress   TEXT," +
            " UserType      INTEGER," +
            " Picture       TEXT," +
            " CreatedOn     TEXT," +
            " ModifiedOn    TEXT," +
            " SyncDate      TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_ProductPromotion = "CREATE TABLE IF NOT EXISTS ProductPromotion " +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " ProductNo TEXT," +
            " ProductName  TEXT," +
            " ProductType   TEXT, " +
            " Description  TEXT," +
            " Benefit   TEXT," +
            " CardNo     TEXT," +
            " BirthDate  TEXT," +
            " CreatedOn      TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_ProductContact = "CREATE TABLE IF NOT EXISTS ProductContact " +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " UserId TEXT," +
            " AgentCallDate  TEXT," +
            " PhoneNumber   TEXT, " +
            " ProductNo  TEXT," +
            " CreatedOn      TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_Poliy = "CREATE TABLE IF NOT EXISTS Poliy " +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " AppId TEXT," +
            " PolicyStatus TEXT," +
            " Status TEXT," +
            " Company TEXT," +
            " Plan TEXT," +
            " StartDate TEXT," +
            " EndDate TEXT," +
            " FirstName TEXT," +
            " LastName TEXT," +
            " MobileNo TEXT," +
            " Province TEXT," +
            " CardNo TEXT," +
            " PolicyCardNo TEXT," +
            " Payer TEXT," +
            " BirthDate TEXT," +
            " Age TEXT," +
            " AgeOnInsure TEXT," +
            " AgeInsure TEXT," +
            " AgentNo TEXT," +
            " AgentName TEXT," +
            " Branch  TEXT," +
            " CreatedOn      TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_Claim = "CREATE TABLE IF NOT EXISTS Claim " +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " ClaimCode TEXT," +
            " ClaimType TEXT," +
            " AccidentDate TEXT," +
            " Hospital TEXT," +
            " HospitalInDate TEXT," +
            " HospitalOutDate TEXT," +
            " Province TEXT," +
            " Description TEXT," +
            " ChiefCormplain TEXT," +
            " Judge TEXT," +
            " BankAccName TEXT," +
            " BankAccNo TEXT," +
            " BankAccType INTEGER," +
            " Bank TEXT," +
            " BankBranch TEXT," +
            " AuthorizeDesc TEXT," +
            " AuthorizeSign TEXT," +
            " AuthorizeDate TEXT," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_Payment = "CREATE TABLE IF NOT EXISTS Payment" +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " AppId TEXT," +
            " ClaimNo TEXT," +
            " InvoiceTotal TEXT," +
            " InvoiceDocType INTEGER," +
            " MedicalCert TEXT," +
            " MedicalCertDocType  INTEGER," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_ClaimDoc = "CREATE TABLE IF NOT EXISTS ClaimDoc" +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " PaymentNo TEXT," +
            " PaymentType INTEGER," +
            " Premium TEXT," +
            " AgentNo TEXT," +
            " InvoiceNo TEXT," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_Complain = "CREATE TABLE IF NOT EXISTS Complain" +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " ComplainNo TEXT," +
            " ComplainType TEXT," +
            " Description TEXT," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_Opportunity = "CREATE TABLE IF NOT EXISTS Opportunity" +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " OpportunityNo TEXT," +
            " FirstName TEXT," +
            " LastName TEXT," +
            " CardNo TEXT," +
            " PhoneNumber1 TEXT," +
            " PhoneNumber2  TEXT," +
            " Email  TEXT," +
            " LineId  TEXT," +
            " Address  TEXT," +
            " Province  TEXT," +
            " Remark  TEXT," +
            " Picture  TEXT," +
            " GPS  TEXT," +
            " AgentNo  TEXT," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_OpportunityProduct = "CREATE TABLE IF NOT EXISTS OpportunityProduct" +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " OpportunityProductNo TEXT," +
            " ProductNo TEXT," +
            " ProductType TEXT," +
            " InsureType TEXT," +
            " Percent TEXT," +
            " Picture TEXT," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_ProductSales = "CREATE TABLE IF NOT EXISTS ProductSalesy" +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " ProductSalesNo TEXT," +
            " AppId TEXT," +
            " ProductNo TEXT," +
            " PolicyMonth TEXT," +
            " PolicyYear TEXT," +
            " ScreenDate  TEXT," +
            " RelationCustomer  TEXT," +
            " CardNo  TEXT," +
            " CustmerName  TEXT," +
            " Career  TEXT," +
            " CareerLavel  TEXT," +
            " PhoneNumber  TEXT," +
            " Email  TEXT," +
            " Address  TEXT," +
            " PaymentType  INTEGER," +
            " Premium  TEXT," +
            " AgentNo  TEXT," +
            " InvoiceNo  TEXT," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_News = "CREATE TABLE IF NOT EXISTS News" +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " NewsNo TEXT," +
            " URL TEXT," +
            " Title TEXT," +
            " Description TEXT," +
            " Picture TEXT," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_Task = "CREATE TABLE IF NOT EXISTS Task" +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " TaskNo TEXT," +
            " Title TEXT," +
            " Description TEXT," +
            " AgentNo TEXT," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";
    public static final String TABLE_Content = "CREATE TABLE IF NOT EXISTS Content" +
            "(RowId INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
            " ContentNo TEXT," +
            " Title TEXT," +
            " Description TEXT," +
            " Picture TEXT," +
            " CreatedOn TEXT," +
            " ModifiedOn  TEXT," +
            " SyncDate  TEXT," +
            " SyncStatus TEXT);";







    public  static  final  String INS_USER = "INSERT INTO Users (UserLogin ,Password ) VALUES (\"Test\",\"123\");";
    public  static  final  String INS_Opportunity = "INSERT INTO Users (FirstName ,LastName ) VALUES (\"Test\",\"Test\");";


    public DataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.i("Test","TestDatabase");

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("Test","CreatetData1");
        db.execSQL(TABLE_USER);
        db.execSQL(TABLE_ProductPromotion);
        db.execSQL(TABLE_ProductContact);
        db.execSQL(TABLE_Poliy);
        db.execSQL(TABLE_Claim);
        db.execSQL(TABLE_Payment);
        db.execSQL(TABLE_ClaimDoc);
        db.execSQL(TABLE_Complain);
        db.execSQL(TABLE_Opportunity);
        db.execSQL(TABLE_OpportunityProduct);
        db.execSQL(TABLE_ProductSales);
        db.execSQL(TABLE_News);
        db.execSQL(TABLE_Task);
        db.execSQL(TABLE_Content);

        db.execSQL(INS_USER);
        db.execSQL(INS_Opportunity);
        Log.i("Test","INSERT_DATA");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
