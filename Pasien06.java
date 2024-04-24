public class Pasien06 {
    String nama;
    int nomorId, umur;
    char jenisKelamin;

    public Pasien06(){
    }
    Pasien06 (String nama, int nomorId, char jenisKelamin, int umur){
        this.nama = nama;
        this.nomorId = nomorId;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
    }
    Pasien06 [] antrian;
    int front;
    int rear;
    int size;
    int max;

    public Pasien06 (int n) {
        max = n;
        antrian = new Pasien06 [max];
        size = 0;
        front = rear = -1;
    }
    public boolean IsEmpty(){
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean IsFull(){
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }
    public void Enqueue(Pasien06 dt) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            antrian[rear] = dt;
            size++;
        }
    }
    public Pasien06 Dequeue() {
        Pasien06 dt = new Pasien06();
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            dt = antrian[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max -1){
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }
    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i].nama + " " + antrian[i].nomorId + " " + antrian[i].jenisKelamin + 
                " " + antrian[i].umur );
                i = (i + 1) % max;
            }
            System.out.println(antrian[i].nama + " " + antrian[i].nomorId + " " + antrian[i].jenisKelamin + 
            " " + antrian[i].umur);
            System.out.println("Jumlah elemen = " + size );
        }
    }
    public void peek() {
        if(!IsEmpty()){
            System.out.println("Pasien terdepan : " + antrian[front].nama);
        } else {
            System.out.println("Antrian masih kosong");
        }
    }
    public void peekRear() {
        if(!IsEmpty()) {
            System.out.println("Atrian Pasien posisi belakang : " + antrian[rear].nama);
        } else {
            System.out.println("Antrian masih kosong");
        }
    }
    public void peekPosition(String nama) {
        int posisi = -1;
        for (int i = 0; i < size; i++) {
            if (antrian[i].nama.equalsIgnoreCase(nama)){
                posisi = i + 1;
                break;
            }
        }
        if (posisi != -1) {
            System.out.println("Pasien " + nama + " berada di posisike-" + posisi);
        } else {
            System.out.println("Pasien " + nama + " tidak ditemukan dalam antrian");
        }
    }
    public void daftarPasien() { 
        if (IsEmpty()) {
            System.out.println("Antrian masih kosong");
        } else {
            System.out.println("Daftar Pasien dalam Antrian : ");
            int i = front;
            do {
                System.out.println(antrian[i].nama);
                i = (i + 1) % max;
            } while (i != rear);
            System.out.println(antrian[i].nama);
        }
    }
}

