## qa_java

# Diplom_3

QA Java Diploma Project

## Дипломный проект.

### Часть 3, Юдина ДИ

* Тестирование веб-приложения [Stellar burgers](https://stellarburgers.nomoreparties.site/)
* Запуск тестов в браузерах:

- По умолчанию тесты запускаются в браузере Chrome.
- Для запуска тестов в Yandex браузере необходимо выбрать YANDEX в качестве параметра в методе '
  WebDriverConfiguration.setDriver(YANDEX)'.
  Далее в настройках конфигурацию запуска в среде разработки или же в командной строке в директории проекта запустить
  строку с конфигурацией (где -Dwebdriver.yandex.bin - путь до бинарника Яндекс браузера)

```bash
mvn -Dbrowser=yandex -Dbdriver.version=122.0.6261.94 -Dwebdriver.yandex.bin="C:/Program Files (x86)/Yandex/YandexBrowser/Application/browser.exe" test
- ```