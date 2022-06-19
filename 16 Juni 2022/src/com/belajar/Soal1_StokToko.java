package com.belajar;

import java.util.*;
import java.io.*;

public class Soal1_StokToko {

    static void tambahData(){
        String database = ("d:\\JavaCRUD\\16 Juni 2022\\database.txt");
        try {

            Scanner input = new Scanner(System.in);
            String ulang;
            String kdBarang,kategoriBarang,nmBarang,stok;

            do {

                System.out.println("+===================================+");
                System.out.println("| Input Stok Barang                 |");
                System.out.println("+===================================+");
                System.out.print("  Kode Barang     : ");
                kdBarang = input.next();
                System.out.print("  Kategori Barang : ");
                kategoriBarang = input.next();
                System.out.print("  Nama Barang     : ");
                nmBarang = input.next();
                System.out.print("  Stok            : " );
                stok = input.next();
                System.out.println("+===================================+");

                BufferedWriter dt = new BufferedWriter(new FileWriter(database,true));

                dt.write(kdBarang + "," + kategoriBarang + "," + nmBarang + "," + stok);
                dt.flush();
                dt.newLine();
                dt.close();
                System.out.print("  Input Data Kembali ( Y / N ) : ");
                ulang = input.next();

                System.out.println("\n");

            } while (ulang.equalsIgnoreCase("Y"));

        } catch (Exception ex){

        }
    }

    static void lihatData(){

        try {
            String kdBarang,kategoriBarang,nmBarang,stok;
            int totStok=0;
            int total=0;

            System.out.println("+============================================================+");
            System.out.println("| Laporan Stok Barang                                        |");
            System.out.println("+============================================================+");
            System.out.println("| No   Kategori     Kode Barang     Nama Barang     Stok     |");
            System.out.println("+============================================================+");

            BufferedReader data = new BufferedReader(new FileReader("d:\\JavaCRUD\\16 Juni 2022\\database.txt"));

            int nomor = 0;
            String isi_data;
            while( ( isi_data = data.readLine() ) != null ){

                StringTokenizer dt = new StringTokenizer(isi_data,",");
                kdBarang = dt.nextToken();
                kategoriBarang = dt.nextToken();
                nmBarang = dt.nextToken();
                stok = dt.nextToken();

                nomor = nomor + 1;

                System.out.println("  " + nomor + "     " + kategoriBarang  + "     " + kdBarang + "             " + nmBarang + "        " + stok);

                totStok = Integer.parseInt(stok);
                total = total + totStok;

            }
            data.close();

            System.out.println("+============================================================+");
            System.out.println("\t\t\t\t\t\t\t\t\t" + "  Total Stok : " + total);
            System.out.println("+============================================================+");
            System.out.println("\n");

        } catch (Exception ex){

        }

    }

    static void cariData(){
        try {
            Scanner input = new Scanner(System.in);
            int pilih;

            System.out.println("+============================================================+");
            System.out.println("| (1) Cari Berdasarkan Kategori             |");
            System.out.println("| (2) Cari Berdasarkan Stok Minimum         |");
            System.out.println("+============================================================+");
            System.out.print("  Pilih : ");
            pilih = input.nextInt();

            if (pilih == 1){
                cariDataKategori();
            } else if (pilih == 2){
                cariDataStok();
            }

        } catch (Exception ex){

        }
    }


    static void cariDataKategori(){
            // PROCEDURE CARI DATA BERDASARKAN KATEGORI
        try {

            Scanner input = new Scanner(System.in);
            String kdBarang,kategoriBarang,nmBarang,stok;
            String cariKategori;

            System.out.println("\n+============================================================+");
            System.out.print("  Jenis Kategori : ");
            cariKategori = input.next();

            System.out.println("\n+============================================================+");
            System.out.println("| Laporan Data Stok by Kategori                              |");
            System.out.println("+============================================================+");
            System.out.println("| No   Nama Barang                                           |");
            System.out.println("+============================================================+");

            BufferedReader data = new BufferedReader(new FileReader("d:\\JavaCRUD\\16 Juni 2022\\database.txt"));

            int nomor=0;
            String isi_data;
            while ( ( isi_data = data.readLine() ) != null ){

                StringTokenizer dt = new StringTokenizer(isi_data,",");
                kdBarang = dt.nextToken();
                kategoriBarang = dt.nextToken();
                nmBarang = dt.nextToken();
                stok = dt.nextToken();

                if (kategoriBarang.equalsIgnoreCase(cariKategori)){

                    nomor = nomor + 1;

                    System.out.println("  " + nomor + "     " + nmBarang);

                }
            }
            data.close();

            System.out.println("+============================================================+");


        } catch (Exception ex){

        }
    }

    static void cariDataStok(){
        try {

            Scanner input = new Scanner(System.in);
            String ulang;
            String kdBarang,kategoriBarang,nmBarang,stok;
            int jumlahStok;
            int total=0;

            do {

                System.out.println("\n+============================================================+");
                System.out.print("  Jumlah Stok yang ingin di lihat : ");
                jumlahStok = input.nextInt();

                System.out.println("\n+============================================================+");
                System.out.println("| Laporan Data Stok by Kategori                              |");
                System.out.println("+============================================================+");
                System.out.println("| No   Nama Barang     Stok                                  |");
                System.out.println("+============================================================+");

                BufferedReader data = new BufferedReader(new FileReader("d:\\JavaCRUD\\16 Juni 2022\\database.txt"));

                int nomor=0;
                String isi_data;
                while ( ( isi_data = data.readLine() ) != null ){

                    StringTokenizer dt = new StringTokenizer(isi_data,",");
                    kdBarang = dt.nextToken();
                    kategoriBarang = dt.nextToken();
                    nmBarang = dt.nextToken();
                    stok = dt.nextToken();


                    // SALAH BAGIAN INI
                    int totStok=0;
                    totStok = Integer.parseInt(stok);
                    total = total + totStok;

                    nomor = nomor + 1;

                    if (jumlahStok <= 10){
                        if (totStok <= 10){
                            System.out.println("  " + nomor + "    " + nmBarang + "              " + stok);
                        }
                    } else if (jumlahStok >= 10){
                        if (totStok > 10){
                            System.out.println("  " + nomor + "    " + nmBarang + "              " + stok);
                        }
                    }

                }

                data.close();

                System.out.println("+============================================================+");
                System.out.print("  Ingin Cari Data Lagi ( Y / N ) : ");
                ulang = input.next();
                System.out.println("+============================================================+");

                if (ulang.equalsIgnoreCase("Y")){
                    cariDataStok();
                }

                System.out.println("+============================================================+");
                System.out.println("\n");

            } while (ulang.equalsIgnoreCase("Y"));

        } catch (Exception ex){

        }
    }

    static void ubahData(){
        try {
            Scanner input = new Scanner(System.in);
            String ubahkdBarang,ubahkategoriBarang,ubahnmBarang,ubahstok;

            System.out.println("+============================================================+");
            System.out.println("| Ubah Data Stok Barang                                      |");
            System.out.println("+============================================================+");
            System.out.print("  Kode Barang          : ");
            ubahkdBarang = input.next();
            System.out.print("  Ubah Kategori Barang : ");
            ubahkategoriBarang = input.next();
            System.out.print("  Ubah Nama Barang     : ");
            ubahnmBarang = input.next();
            System.out.print("  Ubah Stok Barang     : ");
            ubahstok = input.next();

            File fileLama = new File("d:\\JavaCRUD\\16 Juni 2022\\database.txt");
            File fileBaru = new File("d:\\JavaCRUD\\16 Juni 2022\\database_new.txt");

            BufferedReader lama = new BufferedReader(new FileReader(fileLama));
            BufferedWriter baru = new BufferedWriter(new FileWriter(fileBaru));

            String isi_data;
            String kdBarang,kategoriBarang,nmBarang,stok;

            while ( ( isi_data = lama.readLine() ) != null ){

                kdBarang="";
                kategoriBarang="";
                nmBarang="";
                stok="";
                StringTokenizer dt = new StringTokenizer(isi_data,",");
                kdBarang = dt.nextToken();
                kategoriBarang = dt.nextToken();
                nmBarang = dt.nextToken();
                stok = dt.nextToken();

                if ( kdBarang.equalsIgnoreCase(ubahkdBarang) ){

                    baru.write(ubahkdBarang + "," + ubahkategoriBarang + "," + ubahnmBarang + "," + ubahstok);
                    baru.flush();
                    baru.newLine();

                } else {

                    baru.write(kdBarang + "," + kategoriBarang + "," + nmBarang + "," + stok);
                    baru.flush();
                    baru.newLine();

                }

            }

            lama.close();
            baru.close();

            fileLama.delete();
            fileBaru.renameTo(fileLama);

            System.out.println("+============================================================+");
            System.out.println("\n");

        } catch (Exception ex){

        }
    }

    static void hapusData(){
        try {

            Scanner input = new Scanner(System.in);
            String hapus_data;


            System.out.println("+============================================================+");
            System.out.println("|                      Hapus Data Produk                     |");
            System.out.println("+============================================================+");
            System.out.print("  Masukkan Kode Barang : ");
            hapus_data = input.next();

            File fileLama = new File("d:\\JavaCRUD\\16 Juni 2022\\database.txt");
            File fileBaru = new File("d:\\JavaCRUD\\16 Juni 2022\\database_new.txt");

            BufferedReader lama = new BufferedReader(new FileReader(fileLama));
            BufferedWriter baru = new BufferedWriter(new FileWriter(fileBaru));

            String isi_data;
            String kdBarang,kategoriBarang,nmBarang,stok;

            while ( ( isi_data = lama.readLine() ) != null ){

                kdBarang="";
                kategoriBarang="";
                nmBarang="";
                stok="";
                StringTokenizer dt = new StringTokenizer(isi_data,",");
                kdBarang = dt.nextToken();
                kategoriBarang = dt.nextToken();
                nmBarang = dt.nextToken();
                stok = dt.nextToken();

                if ( ! ( kdBarang.equalsIgnoreCase(hapus_data) ) ){

                    baru.write(kdBarang + "," + kategoriBarang + "," + nmBarang + "," + stok);
                    baru.flush();
                    baru.newLine();

                }

            }
            lama.close();
            baru.close();

            fileLama.delete();
            fileBaru.renameTo(fileLama);

            System.out.println("+============================================================+");
            System.out.println("\n");


        } catch (Exception ex){

        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int pilih;
        String ulang="Y";

        while(ulang.equalsIgnoreCase("Y")){

            System.out.println("\n+===================================+");
            System.out.println("|            Toko Sembako           |");
            System.out.println("+===================================+");
            System.out.println("| (1) Tambah Data                   |");
            System.out.println("| (2) Lihat Data                    |");
            System.out.println("| (3) Cari Data                     |");
            System.out.println("| (4) Ubah Data                     |");
            System.out.println("| (5) Hapus Data                    |");
            System.out.println("| (6) Selesai                       |");
            System.out.println("+===================================+");
            System.out.print("  Pilihan : ");
            pilih = input.nextInt();

            System.out.println("\n");

            if (pilih == 1){
                tambahData();
            } else if (pilih == 2){
                lihatData();
            } else if (pilih == 3){
                cariData();
            } else if (pilih == 4){
                ubahData();
            } else if (pilih == 5){
                hapusData();
            } else if (pilih == 6){
                System.out.println("+===================================+");
                System.out.println("| Progam Selesai                    |");
                System.out.println("+===================================+");
                break;
            } else {
                System.out.println("+===================================+");
                System.out.println("| Input tidak tersedia              |");
                System.out.println("+===================================+");
            }

        }

    }
}
