package com.example.androidtest;

import android.content.Context;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * @author heb
 * @class_name MyTextView.java
 * @date 2012-3-22
 */
public class MyCopyTextView extends EditText {

	public MyCopyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	// ���������ı�ѡ���menu�Ĺؼ�����������ѡ���ơ����еȵȹ��ܣ��Ӹ�textview�ľ���ʵ�ֶ���
	// ���ϣ�����������menu���棬ֻҪ������������ؿվ�ok
	@Override
	protected MovementMethod getDefaultMovementMethod() {
		// TODO Auto-generated method stub
		return super.getDefaultMovementMethod();
	}

	// ���menu�е�ѡ��item�ľ��崦��������׽����ı����ơ����еȰ�ť�Ķ���
	// ���Ҫ�ڵ�����ư�ť֮��ȡ����textview��cursor�ɼ��Եľ������д������
	@Override
	public boolean onTextContextMenuItem(int id) {
		setCursorVisible(true);
		boolean flag;
		if (id != android.R.id.switchInputMethod) {
			flag = super.onTextContextMenuItem(id);
		} else {
			setCursorVisible(false);
			return false;
		}
		if (id == android.R.id.copy) {
			setCursorVisible(false);
			cursorStart = -1;
		}
		return flag;
	}

	@Override
	protected void onCreateContextMenu(ContextMenu menu) {
		super.onCreateContextMenu(menu);
		if (isInputMethodTarget()) {
			menu.removeItem(android.R.id.switchInputMethod);
		}
	}

	// textview�ĵ����׽
	// ���˫��textviewѡ���˾������֣���ʹcursor�ɼ�
	int cursorStart = -1;

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		boolean flag = super.onTouchEvent(event);
		if (event.getAction() == MotionEvent.ACTION_DOWN && hasSelection()) {
			if (cursorStart == -1) {// ���ڵ��ѡ�����ֺ��ٵ������λ�ã���һ�ε��ʱ��ʾ��hasSelection��ȻΪtrue������һ��cursor����Ȼ���ڣ�Ϊ�˱��������������������selectionStart������һ����֤
				setCursorVisible(true);
				cursorStart = getSelectionStart();
			} else {
				setCursorVisible(false);
				cursorStart = -1;
			}
		}
		return flag;
	}

	// �������ؼ�ȡ�����ָ���ʱ��ʹcursor�ٴβ��ɼ�
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		boolean flag = super.onKeyDown(keyCode, event);

		setCursorVisible(false);
		cursorStart = -1;
		return flag;
	}

}
