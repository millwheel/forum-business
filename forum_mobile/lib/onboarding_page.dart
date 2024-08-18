import 'package:forum_mobile/component/bottom_space.dart';
import 'package:forum_mobile/service/auth_service.dart';
import 'package:provider/provider.dart';
import 'package:flutter/material.dart';
import 'component/common_elevated_button.dart';
import 'component/head_space.dart';

import 'join_page.dart';
import 'login_page.dart';

class OnBoarding extends StatefulWidget {
  const OnBoarding({super.key});

  @override
  State<OnBoarding> createState() => _OnBoardingState();
}

class _OnBoardingState extends State<OnBoarding> {
  double _opacity = 0.0;

  @override
  void initState() {
    super.initState();

    Future.delayed(const Duration(milliseconds: 1500), () {
      setState(() {
        _opacity = 1.0;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Consumer<AuthService>(
      builder: (context, authService, child) {
        return Scaffold(
          backgroundColor: Colors.white,
          body: SafeArea(
            child: SizedBox(
              width: double.infinity,
              child: Column(
                children: [
                  TopSpace(),
                  AnimatedOpacity(
                    opacity: _opacity,
                    duration: const Duration(seconds: 2),
                    child: Text(
                      textAlign: TextAlign.center,
                      "Make a friend who is reliable.",
                      style: TextStyle(fontSize: 26),
                    ),
                  ),
                  const Spacer(),
                  Column(
                    children: [
                      CommonElevatedButton(
                        text: "Login",
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => LoginPage()),
                          );
                        },
                        backgroundColor: Colors.lightBlue,
                      ),
                      SizedBox(
                        height: 20,
                      ),
                      CommonElevatedButton(
                        text: "Join",
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(builder: (context) => JoinPage()),
                          );
                        },
                        fontColor: Colors.white,
                        backgroundColor: Colors.black,
                      ),
                    ],
                  ),
                  BottomSpace(),
                ],
              ),
            ),
          ),
        );
      },
    );
  }
}
