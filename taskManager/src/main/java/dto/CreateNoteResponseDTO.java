package dto;

import com.rudxkush.taskManager.entities.NoteEntity;
import lombok.AllArgsConstructor;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateNoteResponseDTO {
    private Integer taskId;
    private NoteEntity note;
}
