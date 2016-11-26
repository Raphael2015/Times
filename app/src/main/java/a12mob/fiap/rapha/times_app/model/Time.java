package a12mob.fiap.rapha.times_app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rapha on 25/11/2016.
 */

public class Time implements Parcelable {
    @SerializedName("nome")
    private String nome;
    @SerializedName("estado")
    private String estado;
    @SerializedName("escudo")
    private String escudo;
    @SerializedName("anofundacao")
    private String anofundacao;

    public Time(String nome, String estado, String escudo, String fundacao) {
        this.setNome(nome);
        this.setEstado(estado);
        this.setEscudo(escudo);
        this.setAnofundacao(fundacao);
    }

    protected Time(Parcel in) {
        setNome(in.readString());
        setEstado(in.readString());
        setEscudo(in.readString());
        setAnofundacao(in.readString());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getNome());
        dest.writeString(getEstado());
        dest.writeString(getEscudo());
        dest.writeString(getAnofundacao());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Time> CREATOR = new Creator<Time>() {
        @Override
        public Time createFromParcel(Parcel in) {
            return new Time(in);
        }

        @Override
        public Time[] newArray(int size) {
            return new Time[size];
        }
    };


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getAnofundacao() {
        return anofundacao;
    }

    public void setAnofundacao(String anofundacao) {
        this.anofundacao = anofundacao;
    }
}
