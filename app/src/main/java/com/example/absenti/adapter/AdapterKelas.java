package com.example.absenti.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.absenti.R;
import com.example.absenti.actifity.AddActivity;
import com.example.absenti.actifity.DetailAbsen;
import com.example.absenti.actifity.DosenActivity;
import com.example.absenti.actifity.LoginMhsActivity;
import com.example.absenti.actifity.MainActivity;
import com.example.absenti.actifity.RegisterMhsActivity;
import com.example.absenti.model.ModelKelas;
import com.example.absenti.server.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class AdapterKelas extends RecyclerView.Adapter<AdapterKelas.ListViewHolder> {
    private List<ModelKelas> kelas;
    private Context context;

    public AdapterKelas(List<ModelKelas> kelas) {
        this.kelas = kelas;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_kelas, parent, false);
        AdapterKelas.ListViewHolder holder = new AdapterKelas.ListViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final  ModelKelas model = kelas.get(position);
        holder.matkul.setText(model.getMatkul());
        holder.kelas.setText(model.getKelas());
        holder.tgl.setText(model.getTgl());



            holder.row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailAbsen.class);
                    intent.putExtra("IDK", model.getId());
                    v.getContext().startActivity(intent);
                }
            });

            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(context)
                            .setTitle("Perhatian")
                            .setMessage("Hapus jadwal perkuliahan ini?")
                            .setCancelable(false)
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    setDelete(model.getId());
                                }
                            })
                            .setNegativeButton("Tidak", null)
                            .show();

                }
            });


    }

    private void setDelete(String id) {
        AndroidNetworking.post(UtilsApi.BASE_URL+"delete_kelas.php")
                .addBodyParameter("id", id)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("berhasil", ""+response);
                            String cod = response.getString("code");
                            if (cod.equalsIgnoreCase("1")){
                                Toast.makeText(context,"SUCCESSFUL!", Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(context, DosenActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                context.startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("gagal", "gagal :"+anError);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return kelas.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView tgl, matkul, kelas;
        private RelativeLayout row;
        private RelativeLayout delete;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tgl = itemView.findViewById(R.id.txtTgl);
            kelas = itemView.findViewById(R.id.txtKelas);
            matkul = itemView.findViewById(R.id.txtMatkul);
            row = itemView.findViewById(R.id.rowKls);
            delete = itemView.findViewById(R.id.btnDeletekelas);
        }
    }
}
