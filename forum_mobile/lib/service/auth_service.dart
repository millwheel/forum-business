import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';

class AuthService extends ChangeNotifier {
  User? currentUser() {
    return FirebaseAuth.instance.currentUser;
  }

  void signUp({
    required String email,
    required String password,
    required String passwordConfirm,
    required Function() onSuccess,
    required Function(String err) onError,
  }) async {
    if (email.isEmpty) {
      onError('Enter the email.');
      return;
    } else if (password.isEmpty) {
      onError('Enter the password.');
      return;
    }

    if (password != passwordConfirm) {
      onError(
          'Those passwords are not matched. Please enter same password & confirmation');
      return;
    }

    // sign up success
    try {
      await FirebaseAuth.instance.createUserWithEmailAndPassword(
        email: email,
        password: password,
      );
      onSuccess();
    } on FirebaseAuthException catch (e) {
      if (e.code == 'weak-password') {
        onError('Password should be longer than 6.');
      } else if (e.code == 'email-already-in-use') {
        onError('This email was already used for account.');
      } else if (e.code == 'invalid-email') {
        onError('Check the email form.');
      } else if (e.code == 'user-not-found') {
        onError('There is no user with the email.');
      } else if (e.code == 'wrong-password') {
        onError('Wrong password.');
      } else {
        onError(e.message!);
      }
    } catch (e) {
      onError(e.toString());
    }
  }

  void signIn({
    required String email,
    required String password,
    required Function() onSuccess,
    required Function(String err) onError,
  }) async {
    if (email.isEmpty) {
      onError('Enter the email');
      return;
    } else if (password.isEmpty) {
      onError('Enter the password');
      return;
    }

    try {
      await FirebaseAuth.instance.signInWithEmailAndPassword(
        email: email,
        password: password,
      );
      onSuccess();
      notifyListeners();
    } on FirebaseAuthException catch (e) {
      onError(e.message!);
    } catch (e) {
      onError(e.toString());
    }
  }

  void signOut() async {
    await FirebaseAuth.instance.signOut();
    notifyListeners();
  }
}
