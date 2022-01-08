# Nitter Android (Web)App

## About
This is an app for the popular Twitter front-end, [Nitter](https://github.com/zedeus/nitter). <br>
Thanks to Android WebView, you can have a completely separate app for Nitter and isolate your cookies and history from your main browser app, which is a privacy bonus.

## Nitter Instance
Out of the box, [nitter.net](https://nitter.net) is the default instance the app will use. If this is undesired, you can clone this repo and change the instance to something you prefer and recompile it yourself.
To do this, find [this file](/app/src/main/java/com/plexer0/nitter/MainActivity.java) and edit the following line: <br>
```wv1.loadUrl("https://nitter.instance.url");```

## JavaScript
For the sake of convenience, JavaScript is enabled by defaut so you can run hls video content out of the box.
If you wish to disable JavaScript completely, find [this file](/app/src/main/java/com/plexer0/nitter/MainActivity.java) and edit the following line: <br>
```wv1.getSettings().setJavaScriptEnabled(true/false);```

## Contributions
**This area will be populated when contributions are made.** <br>
If you would like to help out, see [CONTRIBUTING.md](CONTRIBUTING.md).
