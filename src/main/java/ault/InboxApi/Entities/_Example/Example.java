package ault.InboxApi.Entities._Example;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Example {

  @Id
  private String id;
  

}