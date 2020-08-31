package android.example.com.questionsgame.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.example.com.questionsgame.utils.TriviaQuestion;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TriviaQuizHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "TQuiz.db";

    //If you want to add more questions or wanna update table values
    //or any kind of modification in db just increment version no.
    private static final int DB_VERSION =26;
    //Table name
    private static final String TABLE_NAME = "TQ";
    //Id of question
    private static final String UID = "_UID";
    //Question
    private static final String QUESTION = "QUESTION";
    //Option A
    private static final String OPTA = "OPTA";
    //Option B
    private static final String OPTB = "OPTB";
    //Option C
    private static final String OPTC = "OPTC";
    //Option D
    //private static final String OPTD = "OPTD";
    //Answer
    private static final String ANSWER = "ANSWER";
    //So basically we are now creating table with first column-id , sec column-question , third column -option A, fourth column -option B , Fifth column -option C , sixth column -option D , seventh column - answer(i.e ans of  question)
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " +  ANSWER + " VARCHAR(255));";
    //Drop table query
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public TriviaQuizHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        allQuestion();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //OnCreate is called only once
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //OnUpgrade is called when ever we upgrade or increment our database version no
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void allQuestion() {
        ArrayList<TriviaQuestion> arraylist = new ArrayList<>();

        arraylist.add(new TriviaQuestion("Qui joue au foot?", "footbaleur", "grandmere", "maman", "footbaleur"));

        arraylist.add(new TriviaQuestion("Qui mange les bananes  ?", "lapin", "singe", "lion", "singe"));

        arraylist.add(new TriviaQuestion("Qui distibue des cadeaux  ?", "papanoel", "pompier", "policier",  "papanoel"));

        arraylist.add(new TriviaQuestion("Qui éteint le feu ?", "policier", "spiderman", "pompier",  "pompier"));

        arraylist.add(new TriviaQuestion("Qui conduit la voiture ?", "ours", "papa", "tasse",  "papa"));

        arraylist.add(new TriviaQuestion("Qui mange des carottes ?", "lion", "ours", "lapin",  "lapin"));

        arraylist.add(new TriviaQuestion("Qui est le roi de la jungle ?", "tortue", "lion", "vache",  "lion"));

        arraylist.add(new TriviaQuestion("Qui est le plus rapide des animaux ?", "tigre", "tortue", "chat", "tigre"));

        arraylist.add(new TriviaQuestion("Qui a un long cou ?", "chien", "singe", "girafe",  "girafe"));

        arraylist.add(new TriviaQuestion("Qui vit dans l'eau ?", "oiseau", "lion", "poisson",  "poisson"));



        arraylist.add(new TriviaQuestion("Où on joue le foot?", "voiture", "terain", "tasse",  "terain"));

        arraylist.add(new TriviaQuestion("Où on met du café?", "lunette", "lit", "tasse",  "tasse"));

        arraylist.add(new TriviaQuestion("Où on met les déchets?", "terain", "poubelle", "classe", "poubelle"));

        arraylist.add(new TriviaQuestion("Où vivent les animaux?", "jungle", "terain", "classe",  "jungle"));

        arraylist.add(new TriviaQuestion("où vivent les poissons?", "voiture", "mer", "fenetre",  "mer"));

        arraylist.add(new TriviaQuestion("Où on étudie ?", "terain", "mer", "classe",  "classe"));

        arraylist.add(new TriviaQuestion("Où on dort  ?", "lit", "fenetre", "jungle",  "lit"));

        arraylist.add(new TriviaQuestion("Où on fait notre toilette  ?", "lit", "toilette", "classe",  "toilette"));

        arraylist.add(new TriviaQuestion("Où on travaille nos devoirs ?", "fenetre", "terain", "bureau", "bureau"));

        arraylist.add(new TriviaQuestion("Ou se trouve le Maroc ?", "amerique", "australie", "afrique", "afrique"));



        arraylist.add(new TriviaQuestion("Qu’est-ce qu’on mange ??", "voiture", "banane", "tasse",  "banane"));

        arraylist.add(new TriviaQuestion("Qu’est-ce qu’on boit ?", "eau", "pomme", "banane",  "eau"));

        arraylist.add(new TriviaQuestion("Qu'est-ce qu'on utilise pour boire?", "lampe", "poubelle", "tase", "tase"));

        arraylist.add(new TriviaQuestion("Qu'est ce qu'on utilise pour laver le linge?", "termo", "voiture", "lavelinge",  "lavelinge"));

        arraylist.add(new TriviaQuestion("Qu'est-ce que l'on utilise pour mesurer la température ?", "lavelinge", "termo", "lunette",  "termo"));

        arraylist.add(new TriviaQuestion("Qu'est-ce que l'on trouve dans une trousse?", "legumes", "trousse", "medicaments",  "trousse"));

        arraylist.add(new TriviaQuestion("Qu'est ce qu'on trouve dans un marché  ?", "tigre", "footbaleur", "legumes",  "legumes"));

        arraylist.add(new TriviaQuestion("Qu'est ce qu'on trouve dans une boulangerie  ?", "legumes", "ballon", "pain",  "pain"));

        arraylist.add(new TriviaQuestion("Qu'est ce qu'on trouve dans une pharmacie ?", "banane", "legumes", "medicaments", "medicaments"));

        arraylist.add(new TriviaQuestion("Qu'est ce qu'on trouve dans un aéroport ?", "maison", "lion", "avion", "avion"));



        arraylist.add(new TriviaQuestion("من يلعب الكرة؟", "footbaleur", "grandmere", "maman", "footbaleur"));

        arraylist.add(new TriviaQuestion("من يأكل الموز؟", "lapin", "singe", "lion", "singe"));

        arraylist.add(new TriviaQuestion("من يوزع الهدايا؟", "papanoel", "pompier", "policier",  "papanoel"));

        arraylist.add(new TriviaQuestion("من يطفأ الحريق؟", "policier", "spiderman", "pompier",  "pompier"));

        arraylist.add(new TriviaQuestion("من يقود السيارة؟", "ours", "papa", "tasse",  "papa"));

        arraylist.add(new TriviaQuestion("من يأكل الجزر؟", "lion", "ours", "lapin",  "lapin"));

        arraylist.add(new TriviaQuestion("من هو ملك الغابة؟", "tortue", "lion", "vache",  "lion"));

        arraylist.add(new TriviaQuestion("من هو اسرع الحيوانات؟", "tigre", "tortue", "chat", "tigre"));

        arraylist.add(new TriviaQuestion("من له عنق طويل؟", "chien", "singe", "girafe",  "girafe"));

        arraylist.add(new TriviaQuestion("من يعيش بالماء؟", "oiseau", "lion", "poisson",  "poisson"));


        arraylist.add(new TriviaQuestion("أين نلعب الكرة؟", "voiture", "terain", "tasse",  "terain"));

        arraylist.add(new TriviaQuestion("أين نصب القهوة؟", "lunette", "lit", "tasse",  "tasse"));

        arraylist.add(new TriviaQuestion("أين نضع النفايات ؟", "terain", "poubelle", "classe", "poubelle"));

        arraylist.add(new TriviaQuestion("أين تعيش الحيوانات؟", "jungle", "terain", "classe",  "jungle"));

        arraylist.add(new TriviaQuestion("أين تعيش الأسماك؟", "voiture", "mer", "fenetre",  "mer"));

        arraylist.add(new TriviaQuestion("أين ندرس؟", "terain", "mer", "classe",  "classe"));

        arraylist.add(new TriviaQuestion("أين ننام؟", "lit", "fenetre", "jungle",  "lit"));

        arraylist.add(new TriviaQuestion("أين نقضي حاجتنا؟", "lit", "toilette", "classe",  "toilette"));

        arraylist.add(new TriviaQuestion("أين ننجز واجباتنا؟", "fenetre", "terain", "bureau", "bureau"));

        arraylist.add(new TriviaQuestion("أين يقع المغرب؟", "amerique", "australie", "afrique", "afrique"));



        arraylist.add(new TriviaQuestion("ماذا نأكل؟", "voiture", "banane", "tasse",  "banane"));

        arraylist.add(new TriviaQuestion("ماذا نشرب؟", "eau", "pomme", "banane",  "eau"));

        arraylist.add(new TriviaQuestion("ماذا نستعمل للشرب؟", "termo", "voiture", "tase",  "tase"));

        arraylist.add(new TriviaQuestion("ماذا نستعمل لغسل ملابسنا؟", "termo", "voiture", "lavelinge",  "lavelinge"));

        arraylist.add(new TriviaQuestion("ماذا نستعمل لقياس الحرارة؟", "lavelinge", "termo", "lunette",  "termo"));

        arraylist.add(new TriviaQuestion("ماذا نجد بالمقلمة؟", "legumes", "trousse", "medicaments",  "trousse"));

        arraylist.add(new TriviaQuestion("ماذا نشتري من السوق؟", "tigre", "footbaleur", "legumes",  "legumes"));

        arraylist.add(new TriviaQuestion("ماذا نشتري من المخبزة؟", "legumes", "ballon", "pain",  "pain"));

        arraylist.add(new TriviaQuestion("ماذا نشتري من الصيدلية؟", "banane", "legumes", "medicaments", "medicaments"));

        arraylist.add(new TriviaQuestion("ماذا نجد بالمطار؟", "maison", "lion", "avion", "avion"));


        // english
        arraylist.add(new TriviaQuestion("Who is playing football ?", "footbaleur", "grandmere", "maman", "footbaleur"));

        arraylist.add(new TriviaQuestion("Who eats bananas ?", "lapin", "singe", "lion", "singe"));

        arraylist.add(new TriviaQuestion("Who distributes gifts ?", "papanoel", "pompier", "policier",  "papanoel"));

        arraylist.add(new TriviaQuestion("Who calms fire ?", "policier", "spiderman", "pompier",  "pompier"));

        arraylist.add(new TriviaQuestion("Who drives the car ?", "ours", "papa", "tasse",  "papa"));

        arraylist.add(new TriviaQuestion("Who eats carrots ?", "lion", "ours", "lapin",  "lapin"));

        arraylist.add(new TriviaQuestion("Who is the king of the jungle ?", "tortue", "lion", "vache",  "lion"));

        arraylist.add(new TriviaQuestion("Who is the fastest animal ?", "tigre", "tortue", "chat", "tigre"));

        arraylist.add(new TriviaQuestion("Who has a long neck ?", "chien", "singe", "girafe",  "girafe"));

        arraylist.add(new TriviaQuestion("Who lives in watter ?", "oiseau", "lion", "poisson",  "poisson"));



        arraylist.add(new TriviaQuestion("Where do we play football?", "voiture", "terain", "tasse",  "terain"));

        arraylist.add(new TriviaQuestion("Where do we make coffee ?", "lunette", "lit", "tasse",  "tasse"));

        arraylist.add(new TriviaQuestion("Where do we put dishes ?", "terain", "poubelle", "classe", "poubelle"));

        arraylist.add(new TriviaQuestion("Where do animals live ?", "jungle", "terain", "classe",  "jungle"));

        arraylist.add(new TriviaQuestion("Where do fishes live ?", "voiture", "mer", "fenetre",  "mer"));

        arraylist.add(new TriviaQuestion("Where do we study ?", "terain", "mer", "classe",  "classe"));

        arraylist.add(new TriviaQuestion("Where do we sleep ?", "lit", "fenetre", "jungle",  "lit"));

        arraylist.add(new TriviaQuestion("Where is toilet ?", "lit", "toilette", "classe",  "toilette"));

        arraylist.add(new TriviaQuestion("Where do we make our homeworks ?", "fenetre", "terain", "bureau", "bureau"));

        arraylist.add(new TriviaQuestion("Where is Morocco ?", "amerique", "australie", "afrique", "afrique"));



        arraylist.add(new TriviaQuestion("What do we eat ?", "voiture", "banane", "tasse",  "banane"));

        arraylist.add(new TriviaQuestion("What do we drink ?", "eau", "pomme", "banane",  "eau"));

        arraylist.add(new TriviaQuestion("What do we use to drink ?", "lampe", "poubelle", "tase", "tase"));

        arraylist.add(new TriviaQuestion("What do we use to wash our clothes ?", "termo", "voiture", "lavelinge",  "lavelinge"));

        arraylist.add(new TriviaQuestion("What do we use to measure temperature?", "lavelinge", "termo", "lunette",  "termo"));

        arraylist.add(new TriviaQuestion("What do we find in our pencil case ?", "legumes", "trousse", "medicaments",  "trousse"));

        arraylist.add(new TriviaQuestion("What do we find in a market ?", "tigre", "footbaleur", "legumes",  "legumes"));

        arraylist.add(new TriviaQuestion("What do we find in a bakery?", "legumes", "ballon", "pain",  "pain"));

        arraylist.add(new TriviaQuestion("What do we find in a pharmacy ?", "banane", "legumes", "medicaments", "medicaments"));

        arraylist.add(new TriviaQuestion("What do we find in an airport ?", "maison", "lion", "avion", "avion"));


        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<TriviaQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            db.execSQL("delete from "+ TABLE_NAME);
            ContentValues values = new ContentValues();
            for (TriviaQuestion question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());

                values.put(ANSWER, question.getAnswer());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    public List<TriviaQuestion> getAllOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);
        if(cursor!=null && cursor.getCount()>0 && cursor.moveToNext()){

            while (cursor.getPosition() < 30 ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();
            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    public List<TriviaQuestion> getFirstOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToNext()){

            while ( cursor.getPosition() < 10  ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    public List<TriviaQuestion> getSecondOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(10)){

            while ( cursor.getPosition() < 20  ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    public List<TriviaQuestion> getThirdOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(20)){

            while ( cursor.getPosition() < 30 ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }


    public List<TriviaQuestion> getAllArabicOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);
        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(30)){

            while (cursor.getPosition() < 60 ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();
            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    public List<TriviaQuestion> getFirstArabicOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(30)){

            while ( cursor.getPosition() < 40 ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    public List<TriviaQuestion> getSecondArabicOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(40)){

            while ( cursor.getPosition() < 50  ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    public List<TriviaQuestion> getThirdArabicOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(50)){

            while ( cursor.getPosition() < 60 ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    public List<TriviaQuestion> getFirstEnglishOfTheQuestions() {
        Log.i("TriviaQuizHelper", "Hehoo 1 !!");
        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);
        Log.i("TriviaQuizHelper", "Hehoo 2 !!");

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(60)){
            Log.i("TriviaQuizHelper", "Hehoo 3 !!");
            while ( cursor.getPosition() < 70 ) {
                Log.i("TriviaQuizHelper", "Hehoo 4 !!");
                Log.i("TriviaQuizHelper", "Waaaa !! "+cursor.getString(1));
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        Log.i("TriviaQuizHelper", "Hehoo 5 !!");
        return questionsList;
    }

    public List<TriviaQuestion> getSecondEnglishOfTheQuestions() {
        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(70)){

            while ( cursor.getPosition() < 80 ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    public List<TriviaQuestion> getThirdEnglishOfTheQuestions() {
        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(80)){

            while ( cursor.getPosition() < 90 ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    public List<TriviaQuestion> getAllEnglishOfTheQuestions() {
        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if(cursor!=null && cursor.getCount()>0 && cursor.moveToPosition(60)){

            while ( cursor.getPosition() < 90 ) {
                TriviaQuestion question = new TriviaQuestion();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOptA(cursor.getString(2));
                question.setOptB(cursor.getString(3));
                question.setOptC(cursor.getString(4));

                question.setAnswer(cursor.getString(5));
                questionsList.add(question);
                cursor.moveToNext();

            }}

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
