package a12mob.fiap.rapha.times_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import a12mob.fiap.rapha.times_app.R;
import a12mob.fiap.rapha.times_app.listener.OnClickListener;
import a12mob.fiap.rapha.times_app.model.Time;


/**
 * Created by rapha on 25/11/2016.
 */

public class TimesListAdapter extends RecyclerView.Adapter<TimesListAdapter.TimesViewHolder> {
    private Context c;
    private List<Time> times;
    private OnClickListener clickListener;

    public TimesListAdapter(Context c, List<Time> times, OnClickListener clickListener) {
        this.c = c;
        this.times = times; // that's our f data, and now we bind this information
        this.clickListener = clickListener; // O que aquela tela quer fazer com aquela informação
    }

    // Create viewholder
    @Override
    public TimesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c)
                .inflate(R.layout.time_item, parent, false);

        return new TimesViewHolder(v);
    }
    // Bind list items/information
    @Override
    public void onBindViewHolder(final TimesViewHolder holder, final int position) {
        holder.tvNome.setText(times.get(position).getNome());
        holder.tvEstado.setText(times.get(position).getEstado());
        holder.tvFundacao.setText(times.get(position).getAnofundacao());

        // TODO cache images
        Picasso
                .with(c)
                .load(times.get(position).getEscudo())
                .placeholder(R.mipmap.ic_launcher) // default image while image is loadind
                .error(R.mipmap.ic_launcher) // default image when some error has ocurred whilte loading image from Webservice
                .into(holder.ivImage);

        if (clickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onClick(holder.itemView, position);
                }
            });
        }
    }
    public Time getItem(int pos) {
        return times.get(pos);
    }

    @Override
    public int getItemCount() {
        return times.size();
    }
    public static class TimesViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome;
        TextView tvEstado;
        TextView tvFundacao;
        ImageView ivImage;

        public TimesViewHolder(View itemView) {
            super(itemView);

            tvNome = (TextView) itemView.findViewById(R.id.tvNome);
            tvEstado = (TextView) itemView.findViewById(R.id.tvEstado);
            tvFundacao = (TextView) itemView.findViewById(R.id.tvFundacao);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }
}
