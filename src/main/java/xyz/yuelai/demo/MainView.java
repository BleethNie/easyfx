package xyz.yuelai.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import xyz.yuelai.View;
import xyz.yuelai.control.Message;
import xyz.yuelai.control.Notification;

import java.net.URL;
import java.util.ResourceBundle;

public class MainView extends View {

    @FXML
    private Button  successBtn,infoBtn,dangerBtn;
    @FXML
    private ComboBox cbBox;
    @FXML
    private TableView table;
    @FXML
    private TableColumn firstNameCol, lastNameCol, emailCol;


    final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com")
    );


    @Override
    public String fxml() {

        // 相对路径
        return "demoFxml/demo.fxml";
    }

    /**
     * 构造器之前初始化
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        successBtn.getStyleClass().add("button-success");

        cbBox.getItems().add("bb");
        cbBox.getItems().add("cc");
        cbBox.getItems().add("dd");

        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

        table.setItems(data);

        successBtn.setOnAction(actionEvent -> {
            alert("aa", Alert.AlertType.CONFIRMATION);
        });

        infoBtn.setOnAction(actionEvent -> {
            showMessage("bb", Message.Type.INFO);
        });

        dangerBtn.setOnAction(actionEvent -> {
            showNotification("ff", Notification.Type.ERROR,3000);
        });
    }

    public static class Person {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;

        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }
    }
}