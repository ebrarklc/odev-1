import java.util.*;

class Ogrenci {
    String ad;
    int zaman;

    public Ogrenci(String ad, int zaman) {
        this.ad = ad;
        this.zaman = zaman;
    }

    public String getAd() {
        return ad;
    }

    public int getZaman() {
        return zaman;
    }
}

class Yaris {
    List<Ogrenci> ogrenciler;

    public Yaris(List<Ogrenci> ogrenciler) {
        this.ogrenciler = ogrenciler;
    }

    public void ilkUcDereceyiYazdir() {
        Collections.sort(ogrenciler, Comparator.comparingInt(Ogrenci::getZaman));
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". Derece: " + ogrenciler.get(i).ad + " - " + ogrenciler.get(i).zaman + " dakika");
        }
    }

    public int enDusukZamanaSahipOgrenci(int[] zamanlar) {
        int enDusukIndeks = 0;
        int enDusukZaman = zamanlar[0];
        for (int i = 1; i < zamanlar.length; i++) {
            if (zamanlar[i] < enDusukZaman) {
                enDusukZaman = zamanlar[i];
                enDusukIndeks = i;
            }
        }
        return enDusukIndeks;
    }

    public void enIyiKosucuyuYazdir() {
        int enIyiIndeks = enDusukZamanaSahipOgrenci(getZamanlar());
        System.out.println("En iyi koşucu: " + ogrenciler.get(enIyiIndeks).ad + " - " + ogrenciler.get(enIyiIndeks).zaman + " dakika");
    }

    public void ikinciEnIyiKosucuyuYazdir() {
        int[] zamanlar = getZamanlar();
        int enIyiIndeks = enDusukZamanaSahipOgrenci(zamanlar);
        int ikinciEnIyiIndeks = enIyiIndeks == 0 ? 1 : 0;
        for (int i = 0; i < zamanlar.length; i++) {
            if (i != enIyiIndeks && zamanlar[i] < zamanlar[ikinciEnIyiIndeks]) {
                ikinciEnIyiIndeks = i;
            }
        }
        System.out.println("İkinci en iyi koşucu: " + ogrenciler.get(ikinciEnIyiIndeks).ad + " - " + ogrenciler.get(ikinciEnIyiIndeks).zaman + " dakika");
    }

    public void ucuncuEnIyiKosucuyuYazdir() {
        int[] zamanlar = getZamanlar();
        int enIyiIndeks = enDusukZamanaSahipOgrenci(zamanlar);
        int ikinciEnIyiIndeks = enIyiIndeks == 0 ? 1 : 0;
        int ucuncuEnIyiIndeks = enIyiIndeks == 0 ? 2 : (enIyiIndeks == 1 ? 2 : 1);
        for (int i = 0; i < zamanlar.length; i++) {
            if (i != enIyiIndeks && i != ikinciEnIyiIndeks && zamanlar[i] < zamanlar[ucuncuEnIyiIndeks]) {
                ucuncuEnIyiIndeks = i;
            }
        }
        System.out.println("Üçüncü en iyi koşucu: " + ogrenciler.get(ucuncuEnIyiIndeks).ad + " - " + ogrenciler.get(ucuncuEnIyiIndeks).zaman + " dakika");
    }

    public void siniflandir() {
        int[] siniflar = new int[3];
        for (Ogrenci ogrenci : ogrenciler) {
            if (ogrenci.zaman >= 200 && ogrenci.zaman < 300) {
                siniflar[0]++;
            } else if (ogrenci.zaman >= 300 && ogrenci.zaman < 400) {
                siniflar[1]++;
            } else {
                siniflar[2]++;
            }
        }
        System.out.println("A →" + siniflar[0] + ", B →" + siniflar[1] + ", C→" + siniflar[2]);
    }

    private int[] getZamanlar() {
        int[] zamanlar = new int[ogrenciler.size()];
        for (int i = 0; i < ogrenciler.size(); i++) {
            zamanlar[i] = ogrenciler.get(i).zaman;
        }
        return zamanlar;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Ogrenci> ogrenciler = new ArrayList<>();
        ogrenciler.add(new Ogrenci("Kadir", 341));
        ogrenciler.add(new Ogrenci("Gökhan", 273));
        ogrenciler.add(new Ogrenci("Hakan", 278));
        ogrenciler.add(new Ogrenci("Suzan", 329));
        ogrenciler.add(new Ogrenci("Pınar", 445));
        ogrenciler.add(new Ogrenci("Mehmet", 402));
        ogrenciler.add(new Ogrenci("Ali", 388));
        ogrenciler.add(new Ogrenci("Emel", 270));
        ogrenciler.add(new Ogrenci("Fırat", 243));
        ogrenciler.add(new Ogrenci("James", 334));
        ogrenciler.add(new Ogrenci("Jale", 412));
        ogrenciler.add(new Ogrenci("Ersin", 393));
        ogrenciler.add(new Ogrenci("Deniz", 299));
        ogrenciler.add(new Ogrenci("Gözde", 343));
        ogrenciler.add(new Ogrenci("Anıl", 317));
        ogrenciler.add(new Ogrenci("Burak", 265));

        Yaris yaris = new Yaris(ogrenciler);

        System.out.println("İlk üç dereceyi alan öğrenciler:");
        yaris.ilkUcDereceyiYazdir();

        System.out.println("En iyi koşucu:");
        yaris.enIyiKosucuyuYazdir();

        System.out.println("İkinci en iyi koşucu:");
        yaris.ikinciEnIyiKosucuyuYazdir();

        System.out.println("Üçüncü en iyi koşucu:");
        yaris.ucuncuEnIyiKosucuyuYazdir();

        System.out.println("Sınıflandırma:");
        yaris.siniflandir();
    }
}
