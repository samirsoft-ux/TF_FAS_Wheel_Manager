package pe.edu.upc.user.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Comment {
    private Long id;
    private String content;
    private Date publicationDate;
    private Vehicle vehicle;
}
