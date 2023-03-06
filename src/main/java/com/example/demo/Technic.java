package com.example.demo;


import jakarta.persistence.Entity; // анотация что класс является сущностбю и относиться к ORM JPA
import jakarta.persistence.GeneratedValue; // автозаполнение айди
import jakarta.persistence.GenerationType; // indentitry
import jakarta.persistence.Id;

//«машина»: ID, Вид техники (например, мультиварка), Группа техники (например, бытовые
//приборы), Дата ввоза на склад, Дата вывоза со склада, ФИО водителя, увозящего технику со склада.
// CREATE TABLE Technic (
//   ID int (15) NOT NULL AUTO_INCREMENT,
//   type varchar (255) NOT NULL,
//   squad varchar (255) NOT NULL,
//   data_input datetime NOT NULL,
//   data_output datetime NOT NULL,
//   driver varchar (255),
//   PRIMARY KEY (ID)
//                     ) ENGINE=InnODB DEFAULT CHARSET=UTF8
// сущность которую нужно сохранять в базе данных
@Entity
public class Technic {
    private Long ID;
    private String type;
    private String squad;
    private String data_input;
    private String data_output;
    private String driver;

    protected Technic(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getID() { return ID;}
    public void setID(Long ID) {  this.ID = ID;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getSquad() {return squad;}
    public void setSquad(String squad) {this.squad = squad;}

    public String getData_input() {return data_input;}
    public void setData_input(String data_input) {this.data_input = data_input;}

    public String getData_output() {return data_output;}
    public void setData_output(String data_output) {this.data_output = data_output;}

    public String getDriver() {return driver;}
    public void setDriver(String driver) {this.driver = driver;}

    @Override
    public String toString(){
        return "technic [id="+ID+", type="+type+", squad = "+squad+", data_input="+data_input+", data_output="+data_output+", driver = "+driver+"";
    }
}
