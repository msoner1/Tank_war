package Map;

/**
 * Created by soner on 23.11.2015.
 * 2. haritan�n kordinat bilgilerini bulunduran classd�r.
 */
public class Map2 extends Map {

    public static int[] cordinates_x = new int[]{0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13 , 14 , 15 , 16 , 17 , 18 , 19 , 20 , 21 , 22 , 23 , 24 , 25 , 26 , 27 , 28 , 29 , 30 , 31 , 32 , 33 , 34 , 35 , 36 , 37 , 38 , 39 , 40 , 41 , 42 , 43 , 44 , 45 , 46 , 47 , 48 , 49 , 50 , 51 , 52 , 53 , 54 , 55 , 56 , 57 , 58 , 59 , 60 , 61 , 62 , 63 , 64 , 65 , 66 , 67 , 68 , 69 , 70 , 71 , 72 , 73 , 74 , 75 , 76 , 77 , 78 , 79 , 80 , 81 , 82 , 83 , 84 , 85 , 86 , 87 , 88 , 89 , 90 , 91 , 92 , 93 , 94 , 95 , 96 , 97 , 98 , 99 , 100 , 101 , 102 , 103 , 104 , 105 , 106 , 107 , 108 , 109 , 110 , 111 , 112 , 113 , 114 , 115 , 116 , 117 , 118 , 119 , 120 , 121 , 122 , 123 , 124 , 125 , 126 , 127 , 128 , 129 , 130 , 131 , 132 , 133 , 134 , 135 , 136 , 137 , 138 , 139 , 140 , 141 , 142 , 143 , 144 , 145 , 146 , 147 , 148 , 149 , 150 , 151 , 152 , 153 , 154 , 155 , 156 , 157 , 158 , 159 , 160 , 161 , 162 , 163 , 164 , 165 , 166 , 167 , 168 , 169 , 170 , 171 , 172 , 173 , 174 , 175 , 176 , 177 , 178 , 179 , 180 , 181 , 182 , 183 , 184 , 185 , 186 , 187 , 188 , 189 , 190 , 191 , 192 , 193 , 194 , 195 , 196 , 197 , 198 , 199 , 200 , 201 , 202 , 203 , 204 , 205 , 206 , 207 , 208 , 209 , 210 , 211 , 212 , 213 , 214 , 215 , 216 , 217 , 218 , 219 , 220 , 221 , 222 , 223 , 224 , 225 , 226 , 227 , 228 , 229 , 230 , 231 , 232 , 233 , 234 , 235 , 236 , 237 , 238 , 239 , 240 , 241 , 242 , 243 , 244 , 245 , 246 , 247 , 248 , 249 , 250 , 251 , 252 , 253 , 254 , 255 , 256 , 257 , 258 , 259 , 260 , 261 , 262 , 263 , 264 , 265 , 266 , 267 , 268 , 269 , 270 , 271 , 272 , 273 , 274 , 275 , 276 , 277 , 278 , 279 , 280 , 281 , 282 , 283 , 284 , 285 , 286 , 287 , 288 , 289 , 290 , 291 , 292 , 293 , 294 , 295 , 296 , 297 , 298 , 299 , 300 , 301 , 302 , 303 , 304 , 305 , 306 , 307 , 308 , 309 , 310 , 311 , 312 , 313 , 314 , 315 , 316 , 317 , 318 , 319 , 320 , 321 , 322 , 323 , 324 , 325 , 326 , 327 , 328 , 329 , 330 , 331 , 332 , 333 , 334 , 335 , 336 , 337 , 338 , 339 , 340 , 341 , 342 , 343 , 344 , 345 , 346 , 347 , 348 , 349 , 350 , 351 , 352 , 353 , 354 , 355 , 356 , 357 , 358 , 359 , 360 , 361 , 362 , 363 , 364 , 365 , 366 , 367 , 368 , 369 , 370 , 371 , 372 , 373 , 374 , 375 , 376 , 377 , 378 , 379 , 380 , 381 , 382 , 383 , 384 , 385 , 386 , 387 , 388 , 389 , 390 , 391 , 392 , 393 , 394 , 395 , 396 , 397 , 398 , 399 , 400 , 401 , 402 , 403 , 404 , 405 , 406 , 407 , 408 , 409 , 410 , 411 , 412 , 413 , 414 , 415 , 416 , 417 , 418 , 419 , 420 , 421 , 422 , 423 , 424 , 425 , 426 , 427 , 428 , 429 , 430 , 431 , 432 , 433 , 434 , 435 , 436 , 437 , 438 , 439 , 440 , 441 , 442 , 443 , 444 , 445 , 446 , 447 , 448 , 449 , 450 , 451 , 452 , 453 , 454 , 455 , 456 , 457 , 458 , 459 , 460 , 461 , 462 , 463 , 464 , 465 , 466 , 467 , 468 , 469 , 470 , 471 , 472 , 473 , 474 , 475 , 476 , 477 , 478 , 479 , 480 , 481 , 482 , 483 , 484 , 485 , 486 , 487 , 488 , 489 , 490 , 491 , 492 , 493 , 494 , 495 , 496 , 497 , 498 , 499 , 500 , 501 , 502 , 503 , 504 , 505 , 506 , 507 , 508 , 509 , 510 , 511 , 512 , 513 , 514 , 515 , 516 , 517 , 518 , 519 , 520 , 521 , 522 , 523 , 524 , 525 , 526 , 527 , 528 , 529 , 530 , 531 , 532 , 533 , 534 , 535 , 536 , 537 , 538 , 539 , 540 , 541 , 542 , 543 , 544 , 545 , 546 , 547 , 548 , 549 , 550 , 551 , 552 , 553 , 554 , 555 , 556 , 557 , 558 , 559 , 560 , 561 , 562 , 563 , 564 , 565 , 566 , 567 , 568 , 569 , 570 , 571 , 572 , 573 , 574 , 575 , 576 , 577 , 578 , 579 , 580 , 581 , 582 , 583 , 584 , 585 , 586 , 587 , 588 , 589 , 590 , 591 , 592 , 593 , 594 , 595 , 596 , 597 , 598 , 599 , 600 , 601 , 602 , 603 , 604 , 605 , 606 , 607 , 608 , 609 , 610 , 611 , 612 , 613 , 614 , 615 , 616 , 617 , 618 , 619 , 620 , 621 , 622 , 623 , 624 , 625 , 626 , 627 , 628 , 629 , 630 , 631 , 632 , 633 , 634 , 635 , 636 , 637 , 638 , 639 , 640 , 641 , 642 , 643 , 644 , 645 , 646 , 647 , 648 , 649 , 650 , 651 , 652 , 653 , 654 , 655 , 656 , 657 , 658 , 659 , 660 , 661 , 662 , 663 , 664 , 665 , 666 , 667 , 668 , 669 , 670 , 671 , 672 , 673 , 674 , 675 , 676 , 677 , 678 , 679 , 680 , 681 , 682 , 683 , 684 , 685 , 686 , 687 , 688 , 689 , 690 , 691 , 692 , 693 , 694 , 695 , 696 , 697 , 698 , 699 , 700 , 701 , 702 , 703 , 704 , 705 , 706 , 707 , 708 , 709 , 710 , 711 , 712 , 713 , 714 , 715 , 716 , 717 , 718 , 719 , 720 , 721 , 722};
    public static int[] cordinates_y = new int[]{ 361 , 361 , 361 , 361 , 361 , 361 , 361 , 360 , 360 , 360 , 359 , 358 , 357 , 356 , 356 , 356 , 356 , 356 , 356 , 356 , 356 , 356 , 356 , 356 , 356 , 355 , 354 , 354 , 353 , 352 , 351 , 350 , 349 , 348 , 347 , 347 , 346 , 346 , 345 , 345 , 344 , 344 , 343 , 343 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 343 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 342 , 341 , 341 , 341 , 341 , 340 , 340 , 340 , 340 , 339 , 339 , 339 , 338 , 338 , 337 , 337 , 336 , 336 , 335 , 335 , 334 , 334 , 333 , 333 , 332 , 332 , 331 , 331 , 330 , 330 , 329 , 329 , 328 , 328 , 327 , 327 , 326 , 326 , 325 , 325 , 324 , 324 , 323 , 323 , 322 , 322 , 321 , 321 , 320 , 320 , 319 , 319 , 318 , 318 , 317 , 317 , 316 , 316 , 315 , 315 , 314 , 313 , 312 , 311 , 311 , 311 , 311 , 311 , 310 , 310 , 310 , 310 , 310 , 310 , 310 , 310 , 310 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 311 , 310 , 310 , 310 , 310 , 309 , 308 , 307 , 306 , 306 , 305 , 304 , 304 , 303 , 302 , 301 , 301 , 300 , 299 , 299 , 298 , 298 , 297 , 296 , 295 , 295 , 294 , 294 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 293 , 294 , 294 , 295 , 296 , 297 , 298 , 299 , 300 , 301 , 302 , 303 , 303 , 304 , 304 , 305 , 305 , 306 , 306 , 307 , 307 , 308 , 308 , 309 , 309 , 310 , 310 , 311 , 311 , 312 , 312 , 313 , 314 , 314 , 314 , 315 , 315 , 316 , 316 , 317 , 317 , 318 , 318 , 318 , 319 , 319 , 319 , 319 , 320 , 320 , 320 , 320 , 320 , 321 , 321 , 321 , 321 , 321 , 321 , 321 , 321 , 321 , 321 , 321 , 321 , 321 , 320 , 320 , 319 , 318 , 317 , 316 , 316 , 315 , 315 , 314 , 314 , 313 , 312 , 311 , 310 , 309 , 308 , 307 , 306 , 305 , 304 , 303 , 303 , 303 , 303 , 303 , 303 , 303 , 303 , 303 , 303 , 303 , 304 , 304 , 304 , 304 , 304 , 304 , 304 , 304 , 305 , 305 , 305 , 305 , 305 , 305 , 305 , 305 , 305 , 305 , 305 , 305 , 305 , 305 , 306 , 306 , 307 , 307 , 308 , 308 , 309 , 309 , 310 , 310 , 311 , 312 , 313 , 314 , 315 , 316 , 317 , 318 , 319 , 320 , 321 , 322 , 322 , 323 , 324 , 325 , 326 , 327 , 328 , 329 , 330 , 331 , 331 , 331 , 332 , 332 , 332 , 333 , 333 , 333 , 334 , 334 , 334 , 334 , 334 , 335 , 335 , 335 , 335 , 335 , 335 , 336 , 336 , 336 , 336 , 336 , 336 , 336 , 336 , 336 , 337 , 337 , 337 , 337 , 337 , 338 , 338 , 338 , 339 , 339 , 339 , 340 , 340 , 341 , 342 , 342 , 343 , 344 , 345 , 346 , 347 , 348 , 349 , 350 , 351 , 352 , 353 , 354 , 355 , 356 , 357 , 358 , 359 , 360 , 361 , 362 , 363 , 364 , 365 , 366 , 367 , 368 , 369 , 370 , 371 , 372 , 373 , 374 , 375 , 376 , 377 , 378 , 379 , 379 , 380 , 380 , 381 , 381 , 381 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 382 , 381 , 381 , 381 , 381 , 381 , 381 , 381 , 381 , 381 , 380 , 380 , 380 , 380 , 380 , 379 , 379 , 378 , 378 , 377 , 377 , 376 , 376 , 375 , 375 , 374 , 374 , 373 , 372 , 371 , 370 , 370 , 369 , 368 , 367 , 366 , 365 , 364 , 363 , 362 , 361 , 360 , 359 , 358 , 357 , 356 , 355 , 354 , 354 , 354 , 355 , 355 , 356 , 357 , 357 , 356 , 355 , 354 , 353 , 352 , 351 , 350 , 349 , 348 , 347 , 346 , 345 , 344 , 343 , 343 , 342 , 342 , 341 , 341 , 340 , 340 , 339 , 339 , 339 , 338 , 338 , 338 , 338 , 337 , 337 , 337 , 336 , 336 , 336 , 336 , 335 , 335 , 334 , 334 , 334 , 334 , 334 , 333 , 333 , 333 , 333 , 333 , 333 , 333 , 333 , 333 , 333 , 333 , 332 , 332 , 332 , 332 , 332 , 331 , 331 , 331 , 331 , 330 , 330 , 330 , 330 , 330 , 330 , 330 , 330 , 330 , 330 , 330 , 330 , 330 , 330 , 331 , 331 , 331 , 331 , 331 , 331 , 331 , 331 , 331 , 332 , 332 , 332 , 332 , 333 , 333 , 333 , 334 , 334 , 335 , 335 , 336 , 336 , 337 , 337 , 338 , 338 , 339 , 339 , 340 , 340 , 341 , 341 , 342 , 342 , 343 , 343 , 344 , 344 , 344 , 345 , 345 , 346 , 346 , 346 , 347 , 347 , 348 , 348 , 349 , 349 , 349 , 350 , 350 , 350 , 350 , 350 , 350 , 350 , 350 , 350 , 349 , 349 , 349 , 349 , 349 , 349 , 349 , 349 , 349 , 349 , 349};

    public Map2(){
        super.cordinates_x = this.cordinates_x;
        super.cordinates_y = this.cordinates_y;
    }

    public int[] get_map_cordinates_x() {
        return this.cordinates_x;
    }
    public int[] get_map_cordinates_y() {
        return this.cordinates_y;
    }
}
