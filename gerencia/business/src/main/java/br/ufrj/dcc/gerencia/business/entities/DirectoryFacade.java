package br.ufrj.dcc.gerencia.business.entities;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by fausto on 5/10/16.
 */

@Component
public class DirectoryFacade {

  private String studentBasePath;
  private String teacherBasePath;

  public DirectoryFacade(String studentBasePath, String teacherBasePath) {
    this.studentBasePath = studentBasePath;
    this.teacherBasePath = teacherBasePath;
  }

  public void createDirectory(Path path) throws IOException {
    if  (!Files.exists(path)){
      Files.createDirectory(path);
    }
  }

  public void createDirectory(String path) throws IOException {
    createDirectory(Paths.get(path));
  }

  void createStudentDirectory(String uid) throws IOException {
    createDirectory(String.format("%s/%s", studentBasePath, uid));
  }

  void createTeacherDirectory(String uid) throws IOException {
    createDirectory(String.format("%s/%s", teacherBasePath, uid));
  }

}
