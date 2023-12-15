package com.example.bayrakquizuygulamasi

class Bayraklardao {


    fun rastgele5BayrakGetir(veritabaniYardimcisi: VeritabaniYardimcisi):ArrayList<Bayraklar>{
        val bayraklarlistesi = ArrayList<Bayraklar>()
        val db = veritabaniYardimcisi.writableDatabase
        val c = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5",null)

        while (c.moveToNext()){
            var bayrak = Bayraklar(c.getInt(c.getColumnIndexOrThrow("bayrak_id"))
            ,c.getString(c.getColumnIndexOrThrow("bayrak_ad"))
            ,c.getString(c.getColumnIndexOrThrow("bayrak_resim")))
            bayraklarlistesi.add(bayrak)
        }
        return bayraklarlistesi

    }



    fun rastgele3YanlisSecenekGetir(veritabaniYardimcisi: VeritabaniYardimcisi,bayrak_id:Int):ArrayList<Bayraklar>{
        val bayraklarlistesi = ArrayList<Bayraklar>()
        val db = veritabaniYardimcisi.writableDatabase
        val c = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY RANDOM() LIMIT 3",null)

        while (c.moveToNext()){
            var bayrak = Bayraklar(c.getInt(c.getColumnIndexOrThrow("bayrak_id"))
                ,c.getString(c.getColumnIndexOrThrow("bayrak_ad"))
                ,c.getString(c.getColumnIndexOrThrow("bayrak_resim")))
            bayraklarlistesi.add(bayrak)
        }
        return bayraklarlistesi

    }
}