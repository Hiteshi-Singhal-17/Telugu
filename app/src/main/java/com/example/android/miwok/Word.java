package com.example.android.miwok;

    /*
    * {Word} represents a Word in English and Telugu
    * Each object has 2 properties: english translation, telugu translation
    * */
public class Word {
    private String englishWord ;
    private String teluguWord ;
    private int mImageResourceId=NO_IMAGE_PROVIDED ;
    private static final int NO_IMAGE_PROVIDED=-1 ;

   /*
   * Create a new Word object
   *
   * @param englishWord is the English translation of the word
   * @param teluguWord is the Telugu translation of the word
   * */
   public Word(String englishWord,String teluguWord){
       this.englishWord=englishWord ;
       this.teluguWord=teluguWord ;
   }

    /*
     * Create a new Word object
     *
     * @param englishWord is the English translation of the word
     * @param teluguWord is the Telugu translation of the word
     * @param imageId is the ID of image resource
     * */

    public Word(String englishWord,String teluguWord, int imageId){
        this.englishWord=englishWord ;
        this.teluguWord=teluguWord ;
        this.mImageResourceId=imageId ;
    }

    /**
    * Get Default Translation i.e language understood by user (English)
    */
    public String getDefaultTranslation(){
        return englishWord ;
    }

   /*
   * Get Telugu Translation
   */
    public String getTeluguTranslation(){
        return teluguWord ;
    }

    /*
    * Get image resource id
     */
     public int getImageId(){return mImageResourceId ;}

     public boolean hasImage(){
         return mImageResourceId !=NO_IMAGE_PROVIDED ;
     }
}
