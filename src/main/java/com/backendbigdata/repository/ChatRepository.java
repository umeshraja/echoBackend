package com.backendbigdata.repository;

import com.backendbigdata.dto.response.ActiveChatterDto;
import com.backendbigdata.dto.response.ActiveInitiatorDto;
import com.backendbigdata.dto.response.ActiveUserDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Repository
public class ChatRepository {
    public ActiveUserDto getMostActiveUser(){
        try {
            InputStream resource = new ClassPathResource("NoSQLDB_QueryOutput_mostActiveUser_000000_0.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            String [] parts = reader.readLine().split(",");
            return new ActiveUserDto(parts[0],Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ActiveUserDto getLeastActiveUser() {
        try {
            InputStream resource = new ClassPathResource("NoSQLDB_QueryOutput_leastActiveUser_000000_0.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            String [] parts = reader.readLine().split(",");
            return new ActiveUserDto(parts[0],Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ActiveInitiatorDto getMostActiveInitiator() {
        try {
            InputStream resource = new ClassPathResource("NoSQLDB_QueryOutput_mostActiveChatterInitiator_000000_0.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            String [] parts = reader.readLine().split(",");
            return new ActiveInitiatorDto(parts[0],Integer.parseInt(parts[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ActiveChatterDto getMostActiveChatter() {
        try {
            InputStream resource = new ClassPathResource("NoSQLDB_QueryOutput_mostActiveChatter_000000_0.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            String [] parts = reader.readLine().split(",");
            return new ActiveChatterDto(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ActiveChatterDto getMostActiveOppChatter() {
        try {
            InputStream resource = new ClassPathResource("NoSQLDB_QueryOutput_mostActiveOppChatter_000000_0.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            String [] parts = reader.readLine().split(",");
            return new ActiveChatterDto(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ActiveChatterDto getMostActiveCaseChatter() {
        try {
            InputStream resource = new ClassPathResource("NoSQLDB_QueryOutput_mostActiveCaseChatter_000000_0.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            String [] parts = reader.readLine().split(",");
            return new ActiveChatterDto(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
