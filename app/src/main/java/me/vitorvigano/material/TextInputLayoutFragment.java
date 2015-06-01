package me.vitorvigano.material;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TextInputLayoutFragment extends Fragment {

    private EditText mNameEditText;
    private TextInputLayout mNameLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_text_input_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNameEditText = (EditText) view.findViewById(R.id.name);
        mNameLayout = (TextInputLayout) view.findViewById(R.id.name_container);

        Button save = (Button) view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        final String name = mNameEditText.getText().toString();

        if (name.isEmpty()) {
            mNameLayout.setError(getString(R.string.name_required));
            mNameEditText.requestFocus();
        }
    }
}
