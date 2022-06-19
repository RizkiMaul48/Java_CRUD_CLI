package com.belajar;

import java.util.*;
import java.io.*;

public class Soal2_PenjualanToko {

    static void tambahData(){
        // PROCEDURE INPUT / TAMBAH DATA
        String database = ("d:\\JavaCRUD\\16 Juni 2022\\databasePenjualan.txt");

        try {

            Scanner input = new Scanner(System.in);
            String ulang="Y";
            String noPenjualan, nmBarang, jumlah, harga;

            do {

                System.out.println("+====================================+");
                System.out.println("| Input Penjualan Barang             |");
                System.out.println("+====================================+");
                System.out.print("  Nomor Penjualan : ");
                noPenjualan = input.next();
                System.out.print("  Nama Barang     : ");
                nmBarang = input.next();
                System.out.print("  Jumlah          : ");
                jumlah = input.next();
                System.out.print("  Harga           : ");
                harga = input.next();

                BufferedWriter data = new BufferedWriter(new FileWriter(database,true));

                data.write(noPenjualan + "," + nmBarang + "," + jumlah + "," + harga);
                data.flush();
                data.newLine();
                data.close();

                System.out.println("+====================================+");
                System.out.print("  Input Data lagi ( Y / N ) : ");
                ulang = input.next();
                System.out.println("+====================================+\n");

            } while (ulang.equalsIgnoreCase("Y"));

        } catch (Exception ex){
            System.out.println("");
        }
    }

    static void lihatData(){
        // PROCEDURE LIHAT DATA
        try {

            Scanner input = new Scanner(System.in);
            String noPenjualan, nmBarang, jumlah, harga;

            System.out.println("+============================================================================+");
            System.out.println("|                        Lihat Data Penjualan Barang                         |");
            System.out.println("+============================================================================+");
            System.out.println("| No     No Penjualan     Nama Barang      Jumlah     Harga     Subtotal     |");
            System.out.println("+============================================================================+");

            BufferedReader data = new BufferedReader(new FileReader("d:\\JavaCRUD\\16 Juni 2022\\databasePenjualan.txt"));

            int nomor =0;
            String isi_data;
            double subtotal=0;
            int inJumlah=0;
            int inHarga=0;
            int totalJumlah=0;
            double totSubtotal=0;

            while ( ( isi_data = data.readLine() ) != null ){

                StringTokenizer dt = new StringTokenizer(isi_data,",");
                noPenjualan = dt.nextToken();
                nmBarang = dt.nextToken();
                jumlah = dt.nextToken();
                harga = dt.nextToken();

                // Ubah String menjadi Integer agar bisa dilakukan perhitungan
                inJumlah = Integer.parseInt(jumlah);
                inHarga = Integer.parseInt(harga);

                // Rumus Hitung Subtotal
                subtotal = inJumlah * inHarga;
                totalJumlah = totalJumlah + inJumlah;
                totSubtotal = totSubtotal + subtotal;

                nomor = nomor + 1;

                System.out.println("  " + nomor + "\t\t" + noPenjualan + "\t\t\t\t\t" + nmBarang + " \t\t" + jumlah + "\t\t" + harga + "\t\t" + subtotal);


            }
            data.close();

            System.out.println("+============================================================================+");
            System.out.println("  Total : " + "\t\t\t\t\t\t\t\t\t" + totalJumlah + "\t\t\t\t\t" + totSubtotal );
            System.out.println("+============================================================================+");
            System.out.println("\n");

        } catch (Exception ex){
            System.out.println("Error:Data Tidak ditemukan");
        }
    }

    static void cariData(){
        // PROCEDURE MENU UNTUK MEMILIH PENCARIAN BARANG DGN KATEGORI
        try {
            Scanner input = new Scanner(System.in);
            int pilih;

            System.out.println("+========================================+");
            System.out.println("| Cari Data Penjualan                    |");
            System.out.println("+========================================+");
            System.out.println("  (1) Cari data berdasarkan No Penjualan |");
            System.out.println("  (2) Cari data berdasarkan Nama Barang  |");
            System.out.println("+========================================+");
            System.out.print("  Pilihan : ");
            pilih = input.nextInt();

            if (pilih == 1){
                cariByNo();
            } else if (pilih == 2){
                cariByNama();
            } else {
                System.out.println("+========================================+");
                System.out.println("|         Pilihan Tidak tersedia         |");
                System.out.println("+========================================+");
            }

        } catch (Exception ex){

        }
    }

    static void cariByNo(){
        // Procedure pencarian laporan data berdasarkan Nomor Barang
        try {

            Scanner input = new Scanner(System.in);
            String cari_npoPenjualan;
            String noPenjualan, nmBarang, jumlah, harga, subtotal;

            System.out.println("+===========================================================+");
            System.out.println("| Laporan Data Berdasarkan Nomor Penjualan                  |");
            System.out.println("+===========================================================+");
            System.out.print("  Masukkan No Penjualan : ");
            cari_npoPenjualan = input.next();

            System.out.println("+===============================================+");
            System.out.println("| Laporan Data Berdasarkan Nomor Penjualan      |");
            System.out.println("+===============================================+");
            System.out.println("| No     Nomor Barang      Jumlah     Harga     |");
            System.out.println("+===============================================+");

            BufferedReader data = new BufferedReader(new FileReader("d:\\JavaCRUD\\16 Juni 2022\\databasePenjualan.txt"));

            String isi_data;
            int nomor=0;

            while ( (isi_data = data.readLine()) != null ){

                StringTokenizer dt = new StringTokenizer(isi_data,",");
                noPenjualan = dt.nextToken();
                nmBarang = dt.nextToken();
                jumlah = dt.nextToken();
                harga = dt.nextToken();

                if (cari_npoPenjualan.equalsIgnoreCase(noPenjualan)){

                    nomor = nomor + 1;
                    System.out.println("  " + nomor + " \t\t" + noPenjualan + "  \t\t\t" + jumlah + "\t\t " + harga);

                }

            }
            data.close();
            System.out.println("+===============================================+");
            System.out.println("\n");

        } catch (Exception ex){
            System.out.println("Error:Data tidak ditemukan / File Corrupt");
        }
    }

    static void cariByNama(){
                // PROCEDURE CARI DATA PENJUALAN BERDASARKAN NAMA BARANG
        try {
            Scanner input = new Scanner(System.in);
            String cari_nama;

            String noPenjualan, nmBarang, jumlah, harga, subtotal;

            System.out.println("+===========================================================+");
            System.out.println("| Laporan Data Berdasarkan Nama Barang                      |");
            System.out.println("+===========================================================+");
            System.out.print("  Masukkan Nama Barang : ");
            cari_nama = input.next();

            System.out.println("+===============================================+");
            System.out.println("| Laporan Data Berdasarkan Nomor Penjualan      |");
            System.out.println("+===============================================+");
            System.out.println("| No     Nama Barang      Jumlah     Harga      |");
            System.out.println("+===============================================+");

            BufferedReader data = new BufferedReader(new FileReader("d:\\JavaCRUD\\16 Juni 2022\\databasePenjualan.txt"));

            int nomor=0;
            String isi_data;
            while ( ( isi_data = data.readLine() ) != null ){

                StringTokenizer dt = new StringTokenizer(isi_data,",");
                noPenjualan = dt.nextToken();
                nmBarang = dt.nextToken();
                jumlah = dt.nextToken();
                harga = dt.nextToken();

                if (cari_nama.equalsIgnoreCase(nmBarang)){

                    nomor = nomor + 1;

                    System.out.println("  " + nomor + " \t\t" + nmBarang + "  \t\t\t" + jumlah + "\t\t " + harga);

                }

            }
            data.close();

            System.out.println("+===============================================+");
            System.out.println("\n");

        } catch (Exception ex){
            System.out.println("Error:Data tidak ditemukan / File Corrupt");
        }
    }

    static void ubahData(){
        // PROCEDURE UNTUK MENGUBAH DATA PENJUALAN
        try {

            Scanner input = new Scanner(System.in);
            String ubahNoPenjualan, ubahNmBarang, ubahJumlah, ubahHarga;

            System.out.println("+===========================================================+");
            System.out.println("| Ubah Data Penjualan                                       |");
            System.out.println("+===========================================================+");
            System.out.print("  Input No Penjualan : ");
            ubahNoPenjualan = input.next();
            System.out.print("  Ubah Nama Barang   : ");
            ubahNmBarang = input.next();
            System.out.print("  Ubah Jumlah Barang : ");
            ubahJumlah = input.next();
            System.out.print("  Ubah Harga Barang  : ");
            ubahHarga = input.next();
            System.out.println("+===========================================================+");

            File fileLama = new File("d:\\JavaCRUD\\16 Juni 2022\\databasePenjualan.txt");
            File fileBaru = new File("d:\\JavaCRUD\\16 Juni 2022\\databasePenjualan_new.txt");

            BufferedReader lama = new BufferedReader(new FileReader(fileLama));
            BufferedWriter baru = new BufferedWriter(new FileWriter(fileBaru));

            String noPenjualan, nmBarang, jumlah, harga;
            String isi_data;

            while ( ( isi_data = lama.readLine() ) != null ){

                noPenjualan = "";
                nmBarang = "";
                jumlah = "";
                harga = "";
                StringTokenizer dt = new StringTokenizer(isi_data,",");
                noPenjualan = dt.nextToken();
                nmBarang = dt.nextToken();
                jumlah = dt.nextToken();
                harga = dt.nextToken();

                if (ubahNoPenjualan.equalsIgnoreCase(noPenjualan)){
                    baru.write(ubahNoPenjualan + "," + ubahNmBarang + "," + ubahJumlah + "," + ubahHarga);
                    baru.flush();
                    baru.newLine();
                } else {
                    baru.write(noPenjualan + "," + nmBarang + "," + jumlah + "," + harga);
                    baru.flush();
                    baru.newLine();
                }

            }
            baru.close();
            lama.close();

            fileLama.delete();
            fileBaru.renameTo(fileLama);

            System.out.println("\n");

        } catch (Exception ex){
            System.out.println("Error: Data tidak dapat Diubah");
        }
    }

    static void hapusData(){
        // PROCEDURE UNTUK MENGHAPUS DATA PENJUALAN
        try {
            Scanner input = new Scanner(System.in);
            String hapus_data;

            System.out.println("+===========================================================+");
            System.out.println("| Hapus Data Penjualan                                      |");
            System.out.println("+===========================================================+");
            System.out.print("  Input No Penjualan : ");
            hapus_data = input.next();
            System.out.println("+===========================================================+");

            File fileLama = new File("d:\\JavaCRUD\\16 Juni 2022\\databasePenjualan.txt");
            File fileBaru = new File("d:\\JavaCRUD\\16 Juni 2022\\databasePenjualan_new.txt");

            BufferedReader lama = new BufferedReader(new FileReader(fileLama));
            BufferedWriter baru = new BufferedWriter(new FileWriter(fileBaru));

            String noPenjualan, nmBarang, jumlah, harga;
            String isi_data;

            while ( (isi_data = lama.readLine()) != null ){

                noPenjualan = "";
                nmBarang = "";
                jumlah = "";
                harga = "";
                StringTokenizer dt = new StringTokenizer(isi_data,",");
                noPenjualan = dt.nextToken();
                nmBarang = dt.nextToken();
                jumlah = dt.nextToken();
                harga = dt.nextToken();

                if ( ! (hapus_data.equalsIgnoreCase(noPenjualan)) ){
                    baru.write(noPenjualan + "," + nmBarang + "," + jumlah + "," + harga);
                    baru.flush();
                    baru.newLine();
                }

            }
            lama.close();
            baru.close();

            fileLama.delete();
            fileBaru.renameTo(fileLama);

            System.out.println("\n");


        } catch (Exception ex){
            System.out.println("Error:Data Tidak dapat di Hapus");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String ulang="Y";
        int pilihan;

        while ( ulang.equalsIgnoreCase("Y") ){

            System.out.println("\n+====================================+");
            System.out.println("|           Penjualan Toko           |");
            System.out.println("+====================================+");
            System.out.println("| (1) Tambah Data                    |");
            System.out.println("| (2) Lihat Data                     |");
            System.out.println("| (3) Cari Data                      |");
            System.out.println("| (4) Ubah Data                      |");
            System.out.println("| (5) Hapus Data                     |");
            System.out.println("| (6) Selesai                        |");
            System.out.println("+====================================+");
            System.out.print("  Pilihan : ");
            pilihan = input.nextInt();
            System.out.println("\n");

            if (pilihan == 1){
                tambahData();
            } else if (pilihan == 2){
                lihatData();
            } else if (pilihan == 3){
                cariData();
            } else if (pilihan == 4){
                ubahData();
            } else if (pilihan == 5){
                hapusData();
            } else if (pilihan == 6){
                System.out.println("+====================================+");
                System.out.println("|           Progam Selesai           |");
                System.out.println("+====================================+");
                break;
            } else {
                System.out.println("+====================================+");
                System.out.println("|        Pilihan tidak tersedia      |");
                System.out.println("+====================================+");
            }

        }

    }
}
