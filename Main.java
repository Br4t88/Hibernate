package main;
import org.hibernate.*;

import javax.persistence.Query;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel amountLabel;
    private JButton button1;
    private JLabel lab1;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JLabel id1;
    private JLabel name1;
    private JLabel age1;
    private JLabel address1;
    private JLabel amount1;
    private JLabel updateLab;
    private JButton button2;
    private JLabel delLab;
    private JLabel delID;
    private JTextField delText;
    private JButton button3;
    private JLabel showLab;
    private JButton button4;
    private JTextArea showArea;
    private JLabel showAgeLab;
    private JTextField ageBetwen1;
    private JLabel andAge;
    private JTextField ageBetwen2;
    private JButton showAge;
    private JTextArea showAgeArea;
    private JLabel erorLab;
    private JTextArea erorArea;

    public Main (){
        this.setContentPane(panel1);

    }

    public static void main(String[] args) {
        Main jFrame = new Main();
        jFrame.setSize(550, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jFrame.idLabel);
        jFrame.add(jFrame.textField1);
        jFrame.add(jFrame.nameLabel);
        jFrame.add(jFrame.textField2);
        jFrame.add(jFrame.ageLabel);
        jFrame.add(jFrame.textField3);
        jFrame.add(jFrame.addressLabel);
        jFrame.add(jFrame.textField4);
        jFrame.add(jFrame.amountLabel);
        jFrame.add(jFrame.textField5);
        jFrame.add(jFrame.lab1);
        jFrame.add(jFrame.button1);
        jFrame.add(jFrame.id1);
        jFrame.add(jFrame.textField6);
        jFrame.add(jFrame.name1);
        jFrame.add(jFrame.textField7);
        jFrame.add(jFrame.age1);
        jFrame.add(jFrame.textField8);
        jFrame.add(jFrame.address1);
        jFrame.add(jFrame.textField9);
        jFrame.add(jFrame.amount1);
        jFrame.add(jFrame.textField10);
        jFrame.add(jFrame.updateLab);
        jFrame.add(jFrame.button2);
        jFrame.add(jFrame.delLab);
        jFrame.add(jFrame.delID);
        jFrame.add(jFrame.delText);
        jFrame.add(jFrame.button3);
        jFrame.add(jFrame.showLab);
        jFrame.add(jFrame.button4);
        jFrame.add(jFrame.showArea);
        jFrame.add(jFrame.showAgeLab);
        jFrame.add(jFrame.ageBetwen1);
        jFrame.add(jFrame.andAge);
        jFrame.add(jFrame.ageBetwen2);
        jFrame.add(jFrame.showAge);
        jFrame.add(jFrame.showAgeArea);
        jFrame.add(jFrame.erorLab);
        jFrame.add(jFrame.erorArea);
        jFrame.setVisible(true);


        jFrame.button1.addActionListener( e -> {
            Session session = HibernateUtil.createSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Person person = new Person(Integer.parseInt(jFrame.textField1.getText()), jFrame.textField2.getText(), Integer.parseInt(jFrame.textField3.getText()), jFrame.textField4.getText(), Integer.parseInt(jFrame.textField5.getText()));
                session.save(person);
                tx.commit();
            } catch (HibernateException exception) {
                if (tx != null) {
                    tx.rollback();
                }
                jFrame.erorArea.setText(exception.getMessage());
            } finally {
                HibernateUtil.close();
            }
        });

        jFrame.button2.addActionListener( e -> {
            Session session = HibernateUtil.createSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Person person = new Person(Integer.parseInt(jFrame.textField6.getText()), jFrame.textField7.getText(), Integer.parseInt(jFrame.textField8.getText()), jFrame.textField9.getText(), Integer.parseInt(jFrame.textField10.getText()));
                session.update(person);
                tx.commit();
            } catch (HibernateException exception) {
                if (tx != null) {
                    tx.rollback();
                }
                jFrame.erorArea.setText(exception.getMessage());
            } finally {
                HibernateUtil.close();
            }

        });

        jFrame.button3.addActionListener( e -> {
            Session session = HibernateUtil.createSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                int id = Integer.parseInt(jFrame.delText.getText());
                Person deletePerson = (Person) session.get(Person.class, id);
                session.delete(deletePerson);
                tx.commit();
            } catch (HibernateException exception) {
                if (tx != null) {
                    tx.rollback();
                }
                jFrame.erorArea.setText(exception.getMessage());
            } finally {
                HibernateUtil.close();
            }

        });

        jFrame.button4.addActionListener( e -> {
            Session session = HibernateUtil.createSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                List <Person> persons;
                String queryString = "from Person";
                Query query = session.createQuery(queryString);
                persons = query.getResultList();
                for (Person p : persons) {
                    jFrame.showArea.setText(String.valueOf(p));
                }
                tx.commit();
            } catch (HibernateException exception) {
                if (tx != null) {
                    tx.rollback();
                }
                jFrame.erorArea.setText(exception.getMessage());
            } finally {
                HibernateUtil.close();
            }

        });

        jFrame.showAge.addActionListener( e -> {
            Session session = HibernateUtil.createSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                List <Person> persons;
                String age1 = String.valueOf(jFrame.ageBetwen1.getText());
                String age2 = String.valueOf(jFrame.ageBetwen2.getText());
                String hql = "from Person as p where p.age >=" + age1 + "and p.age <=" + age2;
                Query query = session.createQuery(hql);
                persons = query.getResultList();
                for (Person p : persons) {
                    jFrame.showAgeArea.setText(String.valueOf(p));
                }
                tx.commit();
            } catch (HibernateException exception) {
                if (tx != null) {
                    tx.rollback();
                }
                jFrame.erorArea.setText(exception.getMessage());
            } finally {
                HibernateUtil.close();
            }

        });





    }
}
