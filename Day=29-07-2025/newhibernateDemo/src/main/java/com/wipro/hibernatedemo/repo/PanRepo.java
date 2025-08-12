package com.wipro.hibernatedemo.repo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wipro.entity.Pan;
import com.wipro.util.HibernateUtil;

public class PanRepo {

    public static void createPan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter panholder name:");
        String panholderName = sc.nextLine();
        System.out.println("Please enter pan number:");
        String panNumber = sc.nextLine();

        Pan p = new Pan(panholderName, panNumber);
        save(p);
    }
    public static Pan findById(int id) {
        Transaction tx = null;
        Pan pan = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            tx = session.beginTransaction();

            pan = session.get(Pan.class, id);  

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return pan;
    }

    

    public static void updatePan() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter PAN number:");
        String panNumber = sc.nextLine();  

        Pan existingPan = findByPanNumber(panNumber);
        if (existingPan == null) {
            System.out.println("PAN not found with number: " + panNumber);
            return;
        }

        System.out.println("Please enter new PAN holder name:");
        String panholderName = sc.nextLine();

        Pan updatedPan = new Pan(existingPan.getId(), panNumber, panholderName);

        save(updatedPan);
    }





    public static void save(Pan p) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();

            if (p.getId() != 0) {  // update
                Pan existingPan = session.find(Pan.class, p.getId());
                if (existingPan != null) {
                    existingPan.setPanholderName(p.getPanholderName());
                    existingPan.setPanNumber(p.getPanNumber());
                    session.persist(existingPan);
                }
            } else {  // insert
                session.persist(p);
            }

            transaction.commit();
            System.out.println("PAN record saved/updated successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static Pan findByPanNumber(String panNumber) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction tx = session.beginTransaction();
            String hql = "FROM Pan WHERE panNumber = :panNumber";
            Query<Pan> query = session.createQuery(hql, Pan.class);
            query.setParameter("panNumber", panNumber);
            Pan p = query.uniqueResult();
            tx.commit();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void deleteByPanNo(String panNo) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();

            String hql = "FROM Pan WHERE panNumber = :panNumber";
            Query<Pan> query = session.createQuery(hql, Pan.class);
            query.setParameter("panNumber", panNo);
            Pan pan = query.uniqueResult();

            if (pan != null) {
                session.remove(pan);  // delete from DB
                System.out.println("PAN with number " + panNo + " deleted successfully.");
            } else {
                System.out.println("PAN number not found.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }



    public static List<Pan> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction tx = session.beginTransaction();
            String hql = "from Pan";
            Query<Pan> query = session.createQuery(hql, Pan.class);
            List<Pan> list = query.list();
            tx.commit();
            return list;
        }
    }
    
    public static List<String> findAllPanHolderNames() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction tx = session.beginTransaction();
            
            // HQL to select only panholderName column from Pan
            String hql = "SELECT panholderName FROM Pan";
            Query<String> query = session.createQuery(hql, String.class);
            
            List<String> panholderNames = query.list();
            
            tx.commit();
            return panholderNames;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
