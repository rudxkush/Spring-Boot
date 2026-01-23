package dto;

import com.rudxkush.taskManager.entities.NoteEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.System.out;

@NoArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {
        private int id;
        private String title;
        private String description;
        private Date deadline;
        private Boolean completed;
        private List<NoteEntity> notes;
}
