package model;

public class Book {
 private int Id;
 private String title;
 private String author;
 private String publisher;
 private int year;
 private int copies;
 private int totalcopies;
 
public Book(int Id, String title, String author, String publisher, int year, int totalcopies){
    this.Id=Id;
    this.title=title;
    this.author=author;
    this.publisher=publisher;
    this.year=year;
    this.totalcopies=totalcopies;
}

   public int getId(){
       return Id;
   }
   public String getTitle(){
      return title;
   }
   public String getAuthor(){
      return author;
   }
   public String getpublisher(){
      return publisher;
   }
   public int getyear(){
      return year;
   }
   public int getCopies(){
      return copies;
   }
   public int getTotalcopies(){
      return totalcopies;
   }
   public void increasecopies(){
       this.copies+=1;
   }
  public void decreasecopies() {
   if(copies>0){
      this.copies-=1;
   }
  }
  public String fullDetails(){
   return "BookID:"+Id+"|Title:"+"|Author:"+author+"|Publisher:"+publisher+"|Year:"+year+"|copies:"+copies+"|"+totalcopies;
  }
}
  

