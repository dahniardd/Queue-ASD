import java.util.Scanner;
public class QueueMainPasien {
    public static void menu() {
        System.out.println("Pilih menu : ");
        System.out.println("1. Antrian Pasien baru");
        System.out.println("2. Antrian Pasien keluar");
        System.out.println("3. Cek Pasien terdepan");
        System.out.println("4. Cek semua Pasien");
        System.out.println("5. Cek Antrian Pasien di posisi belakang");
        System.out.println("6. Cek Posisi Pasien");
        System.out.println("7. Tampilkan daftar Pasien");
        System.out.println("----------------------------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue : ");
        int jumlah = sc.nextInt();
        Pasien06 antri = new Pasien06(jumlah);

        int pilih;

        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) { 
                case 1:
                System.out.print("Nama : ");
                String nama = sc.nextLine();
                System.out.print("Nomor ID : ");
                int nomorId = sc.nextInt();
                System.out.print("Jenis Kelamin : ");
                char jenisKelamin = sc.next().charAt(0);
                System.out.print("Umur : ");
                int umur = sc.nextInt();
                Pasien06 ps = new Pasien06(nama, nomorId, jenisKelamin, umur);
                sc.nextLine();
                antri.Enqueue(ps);
                break;
            case 2:
                Pasien06 data = antri.Dequeue();
                if (!"".equals(data.nama) && !"".equals(data.nomorId) && !"".equals(data.jenisKelamin) 
                        && data.umur != 0 ) {
                    System.out.println("Antrian yang keluar : " + data.nama + " " + data.nomorId + " " + data.jenisKelamin + " " + data.umur);
                    break;
                }
            case 3:
                antri.peek();
                break;
            case 4:
                antri.print();
                break;
            case 5:
                antri.peekRear();
                break;
            case 6:
                System.out.print("Nama Pasien : ");
                String namaPasien = sc.nextLine();
                antri.peekPosition(namaPasien);
                break;
            case 7:
                antri.daftarPasien();
                break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6 || pilih == 7);
    }
}

