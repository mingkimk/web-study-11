package com.saeyan.controller;

import com.saeyan.controller.commentAction.CommentAction;
import com.saeyan.controller.commentAction.CommentViewAction;
import com.saeyan.controller.commentAction.CommentWriteAction;
import com.saeyan.controller.commentAction.CommentWriteFormAction;

public class ActionFactoryComment {
	private static ActionFactoryComment instance = new ActionFactoryComment();

	private ActionFactoryComment() {
		super();
	}

	public static ActionFactoryComment getInstance() {
		return instance;
	}

	public CommentAction getAction(String command) {
		CommentAction commentaction = null;
		System.out.println("CommnetActionFactory :" + command);
		/* 추가된 부분 */
		if (command.equals("Comment_write")) {
			commentaction = new CommentWriteAction();
		}else if(command.equals("CommentWrite_form")) {
			commentaction = new CommentWriteFormAction();
		}else if(command.equals("CommentView")) {
			commentaction = new CommentViewAction();
		} 
		return commentaction;
	}
}

