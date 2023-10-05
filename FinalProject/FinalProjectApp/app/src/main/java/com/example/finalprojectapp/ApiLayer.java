package com.example.finalprojectapp;

import android.util.Log;

import com.example.finalprojectapp.models.HairColor;
import com.example.finalprojectapp.models.People;
import com.example.finalprojectapp.models.ProgLang;
import com.example.finalprojectapp.services.IHairColorService;
import com.example.finalprojectapp.services.IPeopleService;
import com.example.finalprojectapp.services.IProgLangService;
import com.example.finalprojectapp.services.ServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import retrofit2.Call;

public class ApiLayer {

    // People API håndtering
    public static People getPeopleById(int id) {
        FutureTask<People> futureTask = new FutureTask<>(new Callable<People>() {
            @Override
            public People call() {
                People p = null;
                IPeopleService service = ServiceBuilder.buildService(IPeopleService.class);
                Call<People> request = service.getPeopleById(id);
                try {
                    p = request.execute().body();

                    //Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                } return p;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        People people = null;
        try {
            people = futureTask.get();
            //will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        } return people;
    }

    public static ArrayList<People> getAllPeople() {
        FutureTask<ArrayList<People>> futureTask = new FutureTask<>(new Callable<ArrayList<People>>() {
            @Override
            public ArrayList<People> call() {
                ArrayList<People> p = null;
                IPeopleService service = ServiceBuilder.buildService(IPeopleService.class);
                Call<ArrayList<People>> request = service.getAllPeople();
                try {
                    p = request.execute().body();
                    //Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                } return p;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        ArrayList<People> people = null;
        try {
            people = futureTask.get();
            //will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        } return people;
    }

    public static People addPeople(People inP) {
        FutureTask<People> futureTask = new FutureTask<>(new Callable<People>() {
            @Override
            public People call() {
                People p = null;
                IPeopleService service = ServiceBuilder.buildService(IPeopleService.class);
                Call<People> request = service.addPeople(inP);
                try {
                    p = request.execute().body();

                    //Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                } return p;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        People people = null;
        try {
            people = futureTask.get();
            //will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        } return people;
    }

    public static People updatePeople(People inP) {
        FutureTask<People> futureTask = new FutureTask<>(new Callable<People>() {
            @Override
            public People call() {
                People p = null;
                IPeopleService service = ServiceBuilder.buildService(IPeopleService.class);
                Call<People> request = service.updatePeople(inP);
                try {
                    p = request.execute().body();

                    //Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                } return p;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        People people = null;
        try {
            people = futureTask.get();
            //will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        } return people;
    }

    public static People deletePeopleById(int id) {
        FutureTask<People> futureTask = new FutureTask<>(new Callable<People>() {
            @Override
            public People call() {
                People p = null;
                IPeopleService service = ServiceBuilder.buildService(IPeopleService.class);
                Call<People> request = service.deletePeopleById(id);
                try {
                    p = request.execute().body();

                    //Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                } return p;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        People people = null;
        try {
            people = futureTask.get();
            //will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        } return people;
    }

    // HairColor API håndteres
    public static HairColor getHairColorById(int id) {
        FutureTask<HairColor> futureTask = new FutureTask<>(new Callable<HairColor>() {
            @Override
            public HairColor call() {
                HairColor hc = null;
                IHairColorService service = ServiceBuilder.buildService(IHairColorService.class);
                Call<HairColor> request = service.getHairColorById(id);
                try {
                    hc = request.execute().body();

                    //Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                } return hc;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        HairColor hc = null;
        try {
            hc = futureTask.get();
            //will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        } return hc;
    }

    public static ArrayList<HairColor> getAllHairColors() {
        FutureTask<ArrayList<HairColor>> futureTask = new FutureTask<>(new Callable<ArrayList<HairColor>>() {
            @Override
            public ArrayList<HairColor> call() {
                ArrayList<HairColor> hcList = null;
                IHairColorService service = ServiceBuilder.buildService(IHairColorService.class);
                Call<ArrayList<HairColor>> request = service.getAllHairColors();
                try {
                    hcList = request.execute().body();
                    //Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                } return hcList;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        ArrayList<HairColor> hcList = null;
        try {
            hcList = futureTask.get();
            //will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        } return hcList;
    }

    // ProgLang API håndteres
    public static ProgLang getProgLangById(int id) {
        FutureTask<ProgLang> futureTask = new FutureTask<>(new Callable<ProgLang>() {
            @Override
            public ProgLang call() {
                ProgLang pl = null;
                IProgLangService service = ServiceBuilder.buildService(IProgLangService.class);
                Call<ProgLang> request = service.getProgLangById(id);
                try {
                    pl = request.execute().body();

                    //Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                } return pl;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        ProgLang pl = null;
        try {
            pl = futureTask.get();
            //will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        } return pl;
    }

    public static ArrayList<ProgLang> getAllProgLangs() {
        FutureTask<ArrayList<ProgLang>> futureTask = new FutureTask<>(new Callable<ArrayList<ProgLang>>() {
            @Override
            public ArrayList<ProgLang> call() {
                ArrayList<ProgLang> plList = null;
                IProgLangService service = ServiceBuilder.buildService(IProgLangService.class);
                Call<ArrayList<ProgLang>> request = service.getAllProgLangs();
                try {
                    plList = request.execute().body();
                    //Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                } return plList;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        ArrayList<ProgLang> plList = null;
        try {
            plList = futureTask.get();
            //will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        } return plList;
    }
}
