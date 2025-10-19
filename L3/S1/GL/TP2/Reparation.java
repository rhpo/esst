import java.util.Date;
import java.util.Vector;

public class Reparation {
    public Date date;
    public int duration;
    public String travaux;

    public Vector<Piece> pièces;

    public Reparation(Date date, int duration, String travaux) {
        this.date = date;
        this.duration = duration;
        this.travaux = travaux;
        this.pièces = new Vector<>();
    }

    public float calculerMontantRéparation() {
        float res = 0;

        if (this.pièces != null) {
            for (Piece piece : this.pièces) {
                res += piece.calculerMontant();
            }
        }

        return res;
    }

    public void ajouterPièce(int ref, String nom, int quantite, double prix) {
        if (this.pièces == null) this.pièces = new Vector<>();
        Piece p = null;
        try {
            java.lang.reflect.Constructor<?> ctor = Piece.class.getConstructor(int.class, String.class, int.class, double.class);
            p = (Piece) ctor.newInstance(ref, nom, quantite, prix);
        } catch (Exception e) {
            try {
                p = Piece.class.getDeclaredConstructor().newInstance();
                setFieldOrSetter(p, "ref", ref);
                setFieldOrSetter(p, "nom", nom);
                setFieldOrSetter(p, "quantite", quantite);
                setFieldOrSetter(p, "prix", prix);
            } catch (Exception ex) {
                // can't create piece -> skip
                return;
            }
        }
        this.pièces.add(p);
    }

    public void ajouterPièce(Piece p) {
        if (p == null) return;
        if (this.pièces == null) this.pièces = new Vector<>();
        this.pièces.add(p);
    }

    public void modifierPièce(int ref, String nom, int quantite, double prix) {
        if (this.pièces == null) return;
        for (int i = 0; i < this.pièces.size(); i++) {
            Piece piece = this.pièces.get(i);
            Integer r = getIntValue(piece, "ref", "réf", "getRef");
            if (r != null && r == ref) {
                setFieldOrSetter(piece, "nom", nom);
                setFieldOrSetter(piece, "quantite", quantite);
                setFieldOrSetter(piece, "prix", prix);
                return;
            }
        }
    }

    public void modifierPièce(Piece p) {
        if (this.pièces == null || p == null) return;
        Integer pRef = getIntValue(p, "ref", "réf", "getRef");
        if (pRef != null) {
            for (int i = 0; i < this.pièces.size(); i++) {
                Integer r = getIntValue(this.pièces.get(i), "ref", "réf", "getRef");
                if (r != null && r.equals(pRef)) {
                    this.pièces.set(i, p);
                    return;
                }
            }
        }
        // fallback: replace equal object
        for (int i = 0; i < this.pièces.size(); i++) {
            if (this.pièces.get(i).equals(p)) {
                this.pièces.set(i, p);
                return;
            }
        }
    }

    public void supprimerPièce(int ref) {
        if (this.pièces == null) return;
        for (int i = 0; i < this.pièces.size(); i++) {
            Integer r = getIntValue(this.pièces.get(i), "ref", "réf", "getRef");
            if (r != null && r == ref) {
                this.pièces.remove(i);
                return;
            }
        }
    }

    public boolean isDispo(String nom) {
        if (this.pièces == null || nom == null) return false;
        for (Piece piece : this.pièces) {
            String pNom = getStringValue(piece, "nom", "getNom", "name", "getName");
            if (pNom != null && nom.equals(pNom)) {
                Integer q = getIntValue(piece, "quantite", "quantité", "getQuantite");
                return q != null && q > 0;
            }
        }
        return false;
    }

    public boolean estRéformable() {
        // règle simple : si le montant de la réparation dépasse 1000 => réformable
        return calculerMontantRéparation() > 1000f;
    }

    public void afficherListePièces() {
        if (this.pièces == null || this.pièces.isEmpty()) {
            System.out.println("Aucune pièce.");
            return;
        }
        for (Piece piece : this.pièces) {
            if (piece == null) {
                System.out.println("null");
                continue;
            }
            System.out.println(piece.toString());
        }
    }

    // helper reflection methods
    private Integer getIntValue(Object obj, String... names) {
        if (obj == null) return null;
        for (String name : names) {
            // try getter-like method
            try {
                java.lang.reflect.Method m = obj.getClass().getMethod(name);
                Object val = m.invoke(obj);
                if (val instanceof Number) return ((Number) val).intValue();
            } catch (Exception ignored) {}
            // try getX
            if (!name.toLowerCase().startsWith("get")) {
                String g = "get" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
                try {
                    java.lang.reflect.Method m2 = obj.getClass().getMethod(g);
                    Object val = m2.invoke(obj);
                    if (val instanceof Number) return ((Number) val).intValue();
                } catch (Exception ignored) {}
            }
            // try field
            try {
                java.lang.reflect.Field f = obj.getClass().getDeclaredField(name);
                f.setAccessible(true);
                Object val = f.get(obj);
                if (val instanceof Number) return ((Number) val).intValue();
            } catch (Exception ignored) {}
        }
        return null;
    }

    private String getStringValue(Object obj, String... names) {
        if (obj == null) return null;
        for (String name : names) {
            try {
                java.lang.reflect.Method m = obj.getClass().getMethod(name);
                Object val = m.invoke(obj);
                if (val != null) return val.toString();
            } catch (Exception ignored) {}
            if (!name.toLowerCase().startsWith("get")) {
                String g = "get" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
                try {
                    java.lang.reflect.Method m2 = obj.getClass().getMethod(g);
                    Object val = m2.invoke(obj);
                    if (val != null) return val.toString();
                } catch (Exception ignored) {}
            }
            try {
                java.lang.reflect.Field f = obj.getClass().getDeclaredField(name);
                f.setAccessible(true);
                Object val = f.get(obj);
                if (val != null) return val.toString();
            } catch (Exception ignored) {}
        }
        return null;
    }

    private void setFieldOrSetter(Object obj, String name, Object value) {
        if (obj == null) return;
        Class<?> cls = obj.getClass();
        String setter = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
        try {
            java.lang.reflect.Method m = cls.getMethod(setter, value.getClass());
            m.invoke(obj, value);
            return;
        } catch (Exception ignored) {}
        // try primitive overloads
        try {
            if (value instanceof Integer) {
                java.lang.reflect.Method m2 = cls.getMethod(setter, int.class);
                m2.invoke(obj, ((Integer) value).intValue());
                return;
            }
        } catch (Exception ignored) {}
        try {
            if (value instanceof Double) {
                java.lang.reflect.Method m3 = cls.getMethod(setter, double.class);
                m3.invoke(obj, ((Double) value).doubleValue());
                return;
            }
        } catch (Exception ignored) {}
        // try field assignment
        try {
            java.lang.reflect.Field f = cls.getDeclaredField(name);
            f.setAccessible(true);
            f.set(obj, value);
        } catch (Exception ignored) {}
    }

}
