package Homework10.Notes.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Notes {
     public int id;
     String title;
     String content;
     public String created_at;

     public Notes(String title, String content) {
          this.title = title;
          this.content = content;
     }
}
